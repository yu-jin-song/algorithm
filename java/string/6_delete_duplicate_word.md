# 6. 중복문자제거

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-06
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.util.ArrayList;
  
public class Main {
    public String solution(String str) {
        ArrayList<String> list = new ArrayList<>(); 
        char[] cArr = str.toCharArray();
        int len = str.length();

        for(int i=0; i<len; i++) {
            /* 문자를 문자열로 변환 */
            String s = String.valueOf(cArr[i]);
            /* 리스트 내 문자 존재하는지 확인 후, 없으면 추가 */
            if(!list.contains(s)) {
                list.add(s);
            }
        }

        /* ArrayList를 문자열로 변환 */
        String result = String.join(",", list).replaceAll(",", "");
        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(mc.solution(str));
  }
}
```
- ArrayList
  + 메소드
    - contains
    - add
- ArrayList를 String으로 변환하기
  + https://www.delftstack.com/ko/howto/java/how-to-convert-an-arraylist-to-a-string-in-java/


### 1-2. 다른 방법 - `String.indexOf()`
```java
import java.util.Scanner;
import java.lang.StringBuilder;
  
public class Main {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        char c;

        for(int i=0; i<len; i++) {
            c = str.charAt(i);

            /* 현재 문자의 위치가 처음 발견된 위치라면 추가 */
            if(str.indexOf(c) == i) {
                sb.append(c);
            }
        }

        String result = new String(sb);
        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(mc.solution(str));
  }
}
```
- String
  + 메소드
    - charAt
    - indexOf

---

## 2. 기록 일지
- 문제를 풀면서 조건문에서 반복되는 코드가 있어 거슬렸다. 왼쪽 문자와 오른쪽 문자가 먼저 특수문자인지 확인하는 방법을 사용하면 깔끔하게 정리할 수 있었다. 앞으로 조건문 사용 시 여러 방면에서 생각해봐야겠다.
- 위에 정리해놓은 방법 외에 정규표현식으로도 풀이는 가능하다. 다만, 문자를 문자열로 변환해줘야 하는 로직이 추가되어야 하므로 상당히 비효율적이다.
- 내 답안과 다른 답안을 비교해본 결과, 속도면에서는 내 답안이 더 빨랐다. 그러나 가독성 측면에서 본다면 다른 방안이 더 우수하다. 반복문의 실행 횟수가 많아지게 되면 속도가 얼마나 차이가 날 지는 모르겠다. 만약 실행 횟수가 많더라도 속도 차이가 크지 않다면 유지보수 측면에서 다른 방안을 택할 것 같다.