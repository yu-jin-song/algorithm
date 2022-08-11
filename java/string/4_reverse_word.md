# 4. 단어 뒤집기

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-04
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.lang.StringBuffer;
  
public class Main {
    public String solution(String str) {
        StringBuffer sb = new StringBuffer(str);
        /* 문자열을 거꾸로 뒤집어 String 타입으로 반환 */
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Main mc = new Main();
        Scanner in = new Scanner(System.in);

        /* 읽어들일 단어 갯수 입력받기 */
        int n = in.nextInt();
        in.nextLine();
        
        for(int i=0; i<n; i++) {
            String str = in.nextLine();
            System.out.println(mc.solution(str));
        }
    }
}
```
- `StringBuffer` 클래스의 `reverse()` 메소드 이용
  + `StringBuffer`
    - 내부적으로 버퍼(buffer)라는 독립적인 공간을 가짐
    - 버퍼 크기
      + 기본값 : 문자 16개
      + 생성자를 통해 크기를 별도로 설정 가능
      + 인스턴스 생성 시 사용자가 설정한 크기보다 16개의 문자를 더 저장할 수 있는 크기로 생성됨

### 1-2. 다른 방법 1 - `StringBuilder`
```java
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
  
public class Main {
    public ArrayList<String> solution(String[] arr) {
        ArrayList<String> answer = new ArrayList<>();

        for(String word : arr) {
            String reverse = new StringBuilder(word).reverse().toString();
            answer.add(reverse);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.next();
        }

        for(String word : mc.solution(arr)) {
            System.out.println(word);
        }
    }
}
```
- `StringBuilder` 클래스의 `reverse()` 메소드 이용
  + `String` vs `StringBuffer` vs `StringBuilder`
    ||String|StringBuffer|StringBuilder|
    |:---:|:---|:---|:---|
    |**Storage**|String pool|Heap|Heap|
    |**Modifiable**|x(immutuable)|o(mutuable)|o(matuable)|
    |**Thread Safe**|o|o|x|
    |**Synchronized<br>(thread-safe)**|o|o|x|
    |**Performance**|fast|slow|fast|
    - String : 문자열 연산이 적고 멀티쓰레드 환경인 경우
    - StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경인 경우
    - StringBuilder : 문자열 연산이 많고 단일쓰레드 환경이거나 동기화를 고려하지 않아도 되는 경우
- 결과값을 `ArrayList`로 반환

### 1-3. 다른 방법 2 - 직접 뒤집기
```java
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
  
public class Main {
    public ArrayList<String> solution(String[] arr) {
        ArrayList<String> answer = new ArrayList<>();

        for(String word : arr) {
            /* 문자를 원하는 위치로 변경하기 위해 단어를 문자배열로 변환 */
            char[] cArr = word.toCharArray();

            /* 포인터 선언(왼쪽 인덱스, 오른쪽 인덱스) */
            int left = 0;
            int right = word.length() - 1;

            /* 왼쪽 인덱스가 오른쪽 인덱스보다 작은 동안 문자 교환 */
            while(left < right) {
                char tmp = cArr[left];
                cArr[left] = cArr[right];
                cArr[right] = tmp;

                /* 왼쪽 포인터를 오른쪽으로, 오른쪽 포인터를 왼쪽으로 한 칸씩 이동*/
                left++;
                right--;
            }

            /* 문자배열을 문자열로 변환 */
            String result = String.valueOf(cArr);
            answer.add(result);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.next();
        }

        for(String word : mc.solution(arr)) {
            System.out.println(word);
        }
    }
}
```
- `String.valueOf` : Object의 값을 `String`으로 변환
  + `valueOf()` vs `toString()`
    - 변경하고자 하는 Object가 null인 경우
      + `valueOf()` : 문자열 "null"을 생성하여 반환
      + `toString()` : Null Pointer Exception(NPE) 발생