# 1. 문자 찾기

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-01
<br><br>

## 1. 오답 분석
### 1-1. 내가 작성한 소스코드
```java
import java.util.Scanner;

public class Main {
    public int solution(String str, char c) {
        int len = str.length();
        int cnt = 0;

        for(int i=0; i<len; i++) {
            if(str.charAt(i) == c) {
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase;
        char c = in.next().charAt(0);

        System.out.println(mc.solution(str, c));
    }
}
```
### 1-2. 원인
- 처음에는 아예 대소문자 변환을 생각을 못해서 오답 처리 됨
- 입력받은 문자열의 대소문자 변환까지는 생각을 했는데 입력받은 문자의 대소문자 변환을 미처 생각하지 못함

### 1-3. 느낀점 및 메모
- 문제를 꼼꼼히 읽는 버릇을 들이도록 하자.
- 인스턴스 메소드를 호출하기 위해서는 인스턴스를 생성해야 함
  + static을 붙여주면 따로 인스턴스를 생성하지 않아도 됨

---

## 2. 답안 및 풀이
### 2-1. 방법 1
```java
import java.util.Scanner;

public class Main {
    public int solution(String str, char c) {
        /* 대소문자 변환 */
        //c = Character.toLowerCase(c);
        c = Character.toUpperCase(c);

        int len = str.length();
        int cnt = 0;

        /* 기본 for문 사용 */
        for(int i=0; i<len; i++) {
            if(str.charAt(i) == c) {
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);

        /* 문자열 입력받기 및 대소문자 변환 */
        //String str = in.nextLine().toLowerCase();
        String str = in.nextLine().toUpperCase();

        /* char type 입력받기 */
        char c = in.next().charAt(0);

        System.out.println(mc.solution(str, c));
    }
}
```
- 대소문자를 구분하지 않는다고 했으므로 `toUpperCase` 또는 `toLowerCase`로 대소문자 변환
- 문자/문자열을 입력받기 위해 `Scanner` 클래스의 `next()` 또는 `nextLine()` 메소드 이용
  + 기본적으로 char 타입을 입력받을 수 있는 메소드는 존재하지 않음
    - 문자 1개도 문자열이라고 할 수 있으므로 문자열로 취급
    - 문자열에 문자 1개만 존재 -> String의 `charAt()` 메소드를 통하여 문자열의 첫번째 인덱스인 `0`에 접근
  + [`next()` 와 `nextLine()`의 차이점](https://devlog-wjdrbs96.tistory.com/80)

### 2-2. 방법 2
```java
import java.util.Scanner;

public class Main {
    public int solution(String str, char c) {
        c = Character.toUpperCase(c);
        int cnt = 0;

        /* 향상된 for문 사용 */
        for(char x : str.toCharArray()) {
            if(x == c) {
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase();
        char c = in.next().charAt(0);

        System.out.println(mc.solution(str, c));
    }
}
```
- foreach(향상된 for문)
  + String type을 사용 할 수 없음
	- 배열이나 iterator 제공하는 collection 프레임워크만 가능
    - `String.toCharArray()`
      + String은 각 문자로 이루어져 있고(문자 한 개 한 개로 구성) 문자를 원소로 하는 문자**배열**을 만들어줘야 하기에 사용

---

## 3. 기록 일지
### 3-1. 반복문 조건부 비교
```java
/* 조건 부분에 메소드 바로 사용 */
for(int i=0; i<str.length(); i++) {
    if(str.charAt(i) == c) {
        cnt++;
    }
}
...

/* 변수 사용한 답안 */
...
int len = str.length();
...

for(int i=0; i<len; i++) {
    if(str.charAt(i) == c) {
        cnt++;
    }
}
...
```
예전에 공부할 때 조건문의 조건부, 특히 조건 부분에는 `str.length()`와 같이 메소드를 바로 사용하는 것보다는 변수에 대입하여 사용하는 것이 낫다는 글을 본 적이 있다.<br>
조건부분에 메소드를 바로 사용할 경우, 반복문이 실행되면서 계속해서 메소드를 실행시키게 되므로 성능에 영향을 줄 수 있다는 것이 이유였던 것으로 기억한다.<br>
실행 결과로는 바로 사용이 161ms, 변수 사용이 176ms로 강의 답안이 좀 더 빨랐는데, 반복 횟수가 많지 않아 이러한 결과가 나온 것으로 보인다.

### 3-2. 일반 for문 vs 향상된 for문
동일한 조건으로 for문만 다르게 적용하여 비교한 결과, 일반 for문의 경우 176ms, 향상된 for문의 경우 156ms로 향상된 for문이 더 처리 속도가 빨랐다.

### 3-3. 대소문자 변환 관련 비교
```java
/* 방법 1 */
String str = in.nextLine();
str = str.toUpperCase();

/* 방법 2 */
String str = in.nextLine().toUpperCase();
```
문자열을 입력 받고 한 번 끊은 후 대소문자를 변환하는 게 더 빠를까, 아니면 문자열 입력 - 대소문자 변환까지 한 번에 처리하는게 더 빠를까 궁금해서 비교해봤다.<br>
결과적으로는 한 번 끊은게 161ms, 한 번에 처리한게 160ms로 매우x100 근소하게 한 번에 처리한게 빨랐다.(하지만 이정도면 의미 없다 생각함)