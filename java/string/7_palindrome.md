# 7. 회문 문자열

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-07
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.lang.StringBuilder;
  
public class Main {
    public String solution(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();

        if(word.equals(reverse)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String word = in.next().toUpperCase();

        System.out.println(mc.solution(word));
  }
}
```
- 문자열 비교
  - `String.eqauls()` vs `==`
    ||equals()|==|
    |:---:|:---|:---|
    |**형태**|메소드|연산자|
    |**비교 대상**|대상의 내용 자체|주소값|
  - `String.equalsIgnoreCase(String str)`
    + 소문자와 대문자의 차이를 무시하고 두 문자열을 비교
    + 문자열이 같으면 `true`, 다르면 `false` 리턴
  - `String.compareToIgnoreCase(String str)`
    + 소문자와 대문자의 차이를 무시하고 사전순으로 두 문자열 비교
    + 문자열이 같으면 `0`, 다르면 `0보다 큰 값` 반환

    
- 문자열 뒤집기(reverse)
  + StringBuilder/StringBuffer
    ```java
    String str = "Hello";

    /* StringBuffer 사용시 */
    String sb = new StringBuffer(str).reverse().toString();
    /* StringBuilder 사용시 */
    String sb = new StringBuilder(str).reverse().toString();
    
    System.out.println(sb); // 결과값: Hello
    ```
  + Collections
    ```java
    String str = "Hello"
    
    char[] cArr = str.toCharArray();
    List<Character> list = new ArrayList<>();
    for(char c : cArr) {
        list.add(c);
    }

    Collections.reverse(list);

    /* 출력 */
    // 방법 1
    for(int i=0; i<list.size(); i++) {
        System.out.print(list.get(i));
    }

    // 방법 2
    for(char i : list) {
        System.out.print(list.get(i));
    }

    // 방법 3
    Iterator<Character> iter = list.iterator();
    while(iter.hasNext()) {
        System.out.print(iter.next());
    }

    System.out.println();    // 결과값: Hello
    ```


### 1-2. 다른 방법 - 직접 비교
주어진 문자열의 중간을 기준으로 앞 뒤로 비교해야 한다.<br>
예를 들어, "madam"이라는 문자열이 있다고 가정해보자.<br>
문자열의 총 길이는 5, 인덱스는 0부터 4이다.<br>
문자열의 길이를 반으로 나누면 `5/2=2`로, 중간값의 인덱스는 2가 된다.<br>
이렇게 중간값의 인덱스를 기준으로 맨 앞과 맨 뒤에서부터 비교하면 모든 문자를 처음부터 끝까지 비교하지 않아도 된다.<br>

#### 1-2-1. `char[]`
```java
import java.util.Scanner;
  
public class Main {
    public String solution(String word) {
        String result = "YES";
        char[] cArr = word.toCharArray();
        int len = cArr.length;

        /* 문자열의 중간까지만 비교 */
        for(int i=0; i<len/2 ; i++) {
            /* 앞쪽 인덱스의 문자가 뒷쪽 인덱스의 문자와 같지 않을 경우 */
            if(cArr[i] != cArr[len-1-i]) {
                return "NO";
            }
        }

        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String word = in.next().toUpperCase();
        System.out.println(mc.solution(word));
  }
}
```

#### 1-2-2. `String.charAt()`
```java
import java.util.Scanner;
  
public class Main {
    public String solution(String word) {
        String result = "YES";
        int len = word.length();

        /* 문자열의 중간까지만 비교 */
        for(int i=0; i<len/2; i++) {
            /* 앞쪽 인덱스의 문자가 뒷쪽 인덱스의 문자와 같지 않을 경우 */
            if(word.charAt(i) != word.charAt(len-1-i)) {
                return "NO";
            }
        }

        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String word = in.next().toUpperCase();
        System.out.println(mc.solution(word));
  }
}
```

---

## 2. 기록 일지
위에 언급된 방법들을 비교해 본 결과, 문자 배열로 변환하여 비교하는 방법이 제일 느렸다. reverse() 메소드를 이용한 방법은 제쳐두고, `toCharArray()`와 `charAt()` 중 `toCharArray()`가 더 느린 이유가 궁금해져 찾아보게 되었다. 둘의 차이는 다음과 같다.

- `toCharArray()`
  + 새로운 문자배열을 생성하여 원본 문자열을 `System.arraycopy()`로 복사하여 사본을 반환
- `charAt()`
  + 원본 문자열에서 해당 위치의 문자 반환

즉, `toCharArray()`의 경우 배열을 새로 생성하는 과정이 존재하므로 원본 문자열을 사용하는 `charAt()`보다 느리다는 것이다.

> 참고) [문자열의 모든 문자를 반복하는 가장 빠른 방법](http://daplus.net/java-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%98-%EB%AA%A8%EB%93%A0-%EB%AC%B8%EC%9E%90%EB%A5%BC-%EB%B0%98%EB%B3%B5%ED%95%98%EB%8A%94-%EA%B0%80%EC%9E%A5-%EB%B9%A0%EB%A5%B8-%EB%B0%A9%EB%B2%95/)