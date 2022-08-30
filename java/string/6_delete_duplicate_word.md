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
- 수정중