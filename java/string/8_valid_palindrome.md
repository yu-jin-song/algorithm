# 8. 유효한 팰린드롬

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-08
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.lang.StringBuilder;
  
public class Main {
    public String solution(String input) {
        String result = "YES";
        /* 정규식 이용, 알파벳 제외한 나머지 문자를 빈 문자로 변환 */
        input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
        String reverse = new StringBuilder(input).reverse().toString();
        
        if(!input.equals(reverse)) {
            return "NO";
        }

        return result;
    }
    
    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        /* 공백을 입력받으므로 nextLine() 사용 */
        String input = in.nextLine();
        System.out.println(mc.solution(input));
    }
}
```
- 문자열에서 부분 문자열 제거하는 방법
  + `String.replace()`
    - 문법 : `String replace(char oldChar, char newChar)`
      + oldChar : 교체할 문자
      + newChar : 첫 번째 매개변수를 대체할 문자
  + `StringBuffer.replace()`
    - 문법 : `StringBuffer replace(int start, int end, String str)`
      + start : 지정된 범위의 시작 인덱스
      + end : 지정된 범위의 끝 인덱스
      + str : 지정된 범위의 내용을 대체할 문자열
    - 실제 범위는 `[start, end-1]`
    - String과 유사하지만 mutuable함(새로운 객체 생성 x)
  + `String.replaceAll()`
    - 문법 : `String replaceAll(String regex, String replace)`
      + regex : 정규 표현식
      + replace : 기존 문자열을 대체할 문자열

---

## 2. 기록 일지
위에도 정리를 해놨지만 `replace()`와 `replaceAll()`의 차이는 매개변수로 문자를 사용할 것인가, 정규 표현식을 사용할 것인가이다. 실제 대상 문자열이 어떤 형태인지 모를 경우 `replace()` 메소드를 이용하여 작업하기에는 무리가 있으므로, 이런 경우 정규 표현식을 매개변수로 받는 `replaceAll()` 메소드를 사용하면 좋다.