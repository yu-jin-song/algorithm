# 3. 문장 속 단어

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-03
<br><br>

## 1. 오답 분석
### 1-1. 내가 작성한 소스코드
```java
import java.util.Scanner;
  
public class Main {
  public String solution(String str) {
        String[] arr = str.split(" ");
        String result = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i].length() > result.length()) {
                result = arr[i];
            }
        }

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
### 1-2. 원인
- Scanner의 `nextLine()`와 `next()`의 차이점을 정확히 알지 못함

### 1-3. 느낀점 및 메모
- 직접 정리하지 않으면 금방 휘발된다. 정리하는 습관을 들이자.
- `Scanner`의 `nextLine()` vs `next()`
  + 차이점
    - `nextLine()` : 개행문자를 포함하는 한 라인을 읽고 **개행문자를 버린 나머지**만 리턴
    - `next()` : **공백**을 기준으로 입력을 받음
  + `next()`와 `nextLine()`을 혼합하여 사용할 경우 원하지 않는 결과를 초래할 수 있다.
    - 소스코드
      ```java
      Scanner in = new Scanner(System.in);
    
      String str = in.next();
      System.out.println(str);
    
      str = in.nextLine();
      System.out.println(str);
      ```
    - 입력
      ```shell
      가나다
      마바사
      ```
    - 결과
      ```shell
      가나다
      ```
    - 분석
      + 키보드로 키를 입력하고 `Enter`키를 누르면 입력받은 내용이 '버퍼'라는 기억공간에 저장됨
      + `next()`의 경우 버퍼에서 공백을 구분자로 하여 하나의 단어를 가져오게 됨
      + `nextLine()`의 경우 버퍼에서 개행문자를 구분자로 하여 한 줄을 가져오게 됨
      + 즉, 위의 코드에서 `next()`이 실행되면 버퍼에 개행문자가 남게 되고, 바로  `nextLine()`이 실행되면 남은 개행문자를 인식하여 뒤에 마바사는 버려지게 됨<br>
      -> 따라서, `next()`를 사용하고 `nextLine()`을 뒤 이어 사용하고 싶다면, `nextLine()`을 사용하기 전 개행문자를 처리해주어야 함
---

## 2. 답안 및 풀이
### 2-1. 내 답안
```java
import java.util.Scanner;
  
public class Main {
  public String solution(String str) {
        /* split() 메소드 이용, 공백을 기준으로 문자열 분리 */
        String[] arr = str.split(" ");
        /* 배열의 첫번째 원소를 비교값으로 지정 */
        String result = arr[0];

        /* 두번째 원소부터 반복문 시작(첫번째 원소가 비교값이므로) */
        for(int i=1; i<arr.length; i++) {
            /* 비교값의 길이와 현재 원소의 길이 비교 */
            if(arr[i].length() > result.length()) {
                result = arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        System.out.println(mc.solution(str));
    }
}
```
- 배열의 `length` 속성 이용하여 배열의 길이 추출

### 2-2. 다른 방법 1
```java
import java.util.Scanner;
  
public class Main {
  public String solution(String str) {
        String result = "";
        String[] arr = str.split(" ");
        /* 정수의 최소값으로 단어 길이 초기화 */
        int max = Integer.MIN_VALUE;

        for(String word : arr) {
            /* 현재 단어 길이 추출 */
            int len = word.length();

            /* 현재 단어의 길이가 더 길다면 */
            if(len > max) {
                max = len;
                result = s;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        System.out.println(mc.solution(str));
    }
}
```
- `String[] split(String regex)`
  + 입력받은 **정규표현식** 또는 **특정 문자**를 기준으로 문자열을 분리하여 **배열**에 저장하여 리턴
- 자바에서의 정수의 최대값, 최소값 출력
  + `Integer.MAX_VALUE` : 정수의 최대값(2,147,483,647)
  + `Integer.MIN_VALUE` : 정수의 최소값(-2,147,483,648)

### 2-3. 다른 방법 2
```java
import java.util.Scanner;
  
public class Main {
  public String solution(String str) {
        String result = "";
        
        /* 0으로 단어 길이 초기화 */
        int max = 0;
        int pos;

        /* 공백 위치 리턴, 공백 위치가 발견되지 않는 동안 반복 */
        while((pos = str.indexOf(' ')) != -1) {
            /* 맨 앞부터 pos 전까지 문자열 자르기 */
            String word = str.substring(0, pos);
            int len = word.length();

            if(len > max) {
                max = len;
                result = word;
            }

            /* pos+1 지점부터 끝까지 문자열 자르기 */
            str = str.substring(pos+1);
        }
        
        /* 마지막 단어 처리 */
        if(str.length() > max) {
            result = str;
        }

        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        System.out.println(mc.solution(str));
    }
}
```
- `indexOf()` 메소드
  + 앞에서부터 특정 문자나 문자열을 처음 찾은 인덱스 반환
  + 찾지 못한 경우 `-1` 반환
  + 시작 위치 생략할 경우 0번째(처음) 부터 시작

    |항목|내용|
    |:---:|:---|
    |**문법**|• `public int indexOf(String str)`<br>•  `public int indexOf(String str, int fromIndex)`<br>•  `public int indexOf(int char)`<br>• `public int indexOf(int char, int fromIndex)`|
    |**파라미터**|• `fromIndex()` : 시작 위치|

- `substring()` 메소드
  + 문자열의 일부 반환

    |항목|내용|
    |:---:|:---|
    |**문법**|• `public String substring(int startIndex)`<br>•  `public String substring(int startIndex, int endIndex)`|
    |**파라미터**|• `startIndex` : 시작위치(포함)<br>• `endIndex` : 종료위치(미포함)|

---

## 3. 기록 일지
### 3-1. `substring()` vs `split()` 실행 속도 비교
동일한 조건에서 비교한 결과 `substring()`을 사용한 경우 174ms, `split()`을 사용한 경우 162ms로 `split()`을 사용하는 게 더 빨랐다. `substring()`을 사용한 경우 시작 위치 조정 및 마지막 단어 처리라는 단계가 추가되어 시간이 더 걸리는 것으로 추정된다.