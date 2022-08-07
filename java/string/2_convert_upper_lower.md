# 2. 대소문자 변환

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-02
<br><br>

## 1. 오답 분석
### 1-1. 내가 작성한 소스코드
```java
import java.util.Scanner;
  
public class Main {
  public String solution(String str) {
        String result = '';
        
        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else {
                c = Character.toUpperCase(c);
            }

            result += c;
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
### 1-2. 원인
- 문자열을 초기화 할 때 큰 따옴표("")로 초기화해야 하는데 작은 따옴표('')로 초기화 하여 컴파일 에러가 남

### 1-3. 느낀점 및 메모
- 문자열(String)을 초기화 할 때는 큰 따옴표(""), 문자(char)를 초기화 할 때는 작은 따옴표('')를 사용

---

## 2. 답안 및 풀이
### 2-1. 방법 1
```java
import java.util.Scanner;
  
public class Main {

    public String solution(String str) {
        String result = "";
        
        /* 향상된 for문(foreach) 사용, 문자열을 문자배열로 변환*/
        for(char c : str.toCharArray()) {
            /* 방법 1. 현재 문자가 대문자인지 확인 */
            //if(Character.isLowerCase(c)) {
            if(Character.isUpperCase(c)) {
                /* 대문자인 경우 소문자로 변경 */
                // c = Character.toUpperCase(c);
                c = Character.toLowerCase(c);
            } else {
                /* 소문자인 경우 대문자로 변경 */
                // c = Character.toLowerCase(c);
                c = Character.toUpperCase(c);
            }

            /* 반환할 문자열에 변환한 문자 추가 */
            result += c;
        }
        
        return result;
    }

    public static void main(String[] args){
        Main mc = new Main();

        Scanner in = new Scanner(System.in);

        //String str = in.next();
        String str = in.nextLine();
        
        System.out.println(mc.solution(str));
    }
}
```

### 2-2. 방법 2
```java
import java.util.Scanner;
  
public class Main {

    public String solution(String str) {
        String result = "";
        
        for(char c : str.toCharArray()) {
            /* 현재 문자가 대문자인지 확인 */
            //if(c >= 97 && c <= 122) {
            if(c >= 65 && c <= 90) {
                //result += (char)(c-32);
                result += (char)(c+32);
            } else {
                //result += (char)(c+32);
                result += (char)(c-32);
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
- [ASCII](https://ko.wikipedia.org/wiki/ASCII) code를 이용하여 풀이
  + 65 ~ 90 : 대문자(A ~ Z)
  + 97 ~ 122 : 소문자(a ~ z)
  + 대문자와 소문자의 차이는 `32`
- `char`는 원래 정수형이며, 연산자를 사용할 경우 정수로 인식하게 됨

---

## 3. 기록 일지
### 3-1. ASCII code vs 대소문자 변환 메소드
ASCII code를 이용한 풀이는 163ms, 대소문자 변환 메소드를 이용한 풀이는 154ms로 **대소문자 변환 메소드**를 사용하는게 더 빨랐다.