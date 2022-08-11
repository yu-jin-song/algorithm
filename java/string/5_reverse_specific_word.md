# 5. 특정 문자 뒤집기

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-05
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.lang.StringBuilder;
  
public class Main {

    public String solution(String str) {
        /* 알파벳 비교 기준 통일을 위해 대문자로 변환 후 문자 배열로 변환 */
        char[] cArr1 = str.toUpperCase().toCharArray();
        /* 원본 문자열 문자 배열로 변환 */
        char[] cArr2 = str.toCharArray();
        
        /* 문자열 인덱스 포인터 선언 */
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            /* 왼쪽에 위치한 문자가 알파벳인 경우 */
            if(cArr1[left] >= 'A' && cArr1[left] <= 'Z') {
                /* 오른쪽에 위치한 문자가 알파벳인 경우 */
                if(cArr1[right] >= 'A' && cArr1[right] <= 'Z') {
                    char temp = cArr2[left];
                    cArr2[left] = cArr2[right];
                    cArr2[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }

        /* 문자 배열을 문자열로 변환 */
        String answer = String.valueOf(cArr2);

        return answer;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(mc.solution(str));
    }
}
```

### 1-2. 다른 방법 - `Character.isAlphabetic`
```java
import java.util.Scanner;
  
public class Main {

    public String solution(String str) {
        char[] cArr = str.toCharArray();
        
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            /*현재 문자가 특수문자인지 확인*/
            if(!Character.isAlphabetic(cArr[left])) {
                left++;
            } else if(!Character.isAlphabetic(cArr[right])) {
                right--;
            } else {    // 현재 left와 right 인덱스에 위치한 문자가 알파벳이라면 바꾸기
                char tmp = cArr[left];
                cArr[left] = cArr[right];
                cArr[right] = tmp;
                left++;
                right--;
            }
        }

        String answer = String.valueOf(cArr);
        return answer;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(mc.solution(str));
    }
}
```
- Character 클래스의 isAlphabetic 메소드
  + 지정된 문자가 알파벳인지 여부 판단
  + 형식 : `public static Boolean isAlphabetic(int codePoint)`

---

## 2. 기록 일지
- 문제를 풀면서 조건문에서 반복되는 코드가 있어 거슬렸다. 왼쪽 문자와 오른쪽 문자가 먼저 특수문자인지 확인하는 방법을 사용하면 깔끔하게 정리할 수 있었다. 앞으로 조건문 사용 시 여러 방면에서 생각해봐야겠다.
- 위에 정리해놓은 방법 외에 정규표현식으로도 풀이는 가능하다. 다만, 문자를 문자열로 변환해줘야 하는 로직이 추가되어야 하므로 상당히 비효율적이다.
- 내 답안과 다른 답안을 비교해본 결과, 속도면에서는 내 답안이 더 빨랐다. 그러나 가독성 측면에서 본다면 다른 방안이 더 우수하다. 반복문의 실행 횟수가 많아지게 되면 속도가 얼마나 차이가 날 지는 모르겠다. 만약 실행 횟수가 많더라도 속도 차이가 크지 않다면 유지보수 측면에서 다른 방안을 택할 것 같다.