# 9. 숫자만 추출

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-09
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
  
public class Main {
    public int solution(String input) {
        /* 숫자를 제외한 나머지 문자를 제거하고 문자열을 숫자로 변환 */
        int num = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        return num;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(mc.solution(input));
    }
}
```
- 자연수를 출력해야하므로 `Integer.parseInt()` 메소드를 이용하여 문자열을 정수로 변환
  + `static int parseInt(String s)`
    - 문자열 인수를 부호 있는 십진 정수로 변환
  + `static int parseInt(String s, int radix)`
    - 문자열 인수를 두 번째 인수로 지정된 진수의 부호 있는 정수로 변환

### 1-2. 다른 방법 1 - Ascii 코드
```java
import java.util.Scanner;
  
public class Main {
    public int solution(String input) {
        int num = 0;
        
        for(char c : input.toCharArray()) {
            if(c >= 48 && c <=57) {
                /* 앞에서 추출한 숫자를 한 자릿수 올리고 현재 숫자를 일의 자리에 놓기 */
                num = num*10 + (c-48);
            }
        }
        
        return num;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(mc.solution(input));
    }
}
```
- Ascii code를 이용
  + 48 ~ 57 : 문자 '0' ~ '9' 
  + 문자를 숫자로 변환하기 위해서는 현재 문자에서 48을 빼야함
    - ex) 문자 '0'은 48, `48(='0')-48 = 0`

### 1-3. 다른 방법 2 - `Character.isDigit()`
```java
import java.util.Scanner;
  
public class Main {
    public int solution(String input) {
        String result = "";
        
        for(char c : input.toCharArray()) {
            /* 현재 문자가 숫자인지 판별 */
            if(Character.isDigit(c)) {
                result += c;
            }
        }
        
        return Integer.parseInt(result);
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(mc.solution(input));
    }
}
```
- `Character.isDigit()`
  + 형식
    - `static boolean isDigit(char c)`
      + 지정된 문자가 숫자인지 확인
    - `static boolean isDigit(int codePoint)`
      + 지정된 문자(유니코드 코드 포인트)가 숫자인지 확인

---

## 2. 기록 일지
### 2-1. 문자열(String)을 정수(int)로 변환하는 방법
- `String.replaceAll()` + `Integer.parseInt()`
  ```java
  public class Main {
    public static void main(String[] args) {
        String str = "1234x";
        int num = str.replaceAll("[^\\d]", "");
        //int num = str.replaceAll("[\\D]", "");
        System.out.println(num);    // 결과값: 1234
    }
  }
  ```
  - 정규 표현식
    + `\d` : 0~9 사이의 숫자(=`[0-9]`)
    + `\D` : 숫자가 아닌 문자(=`[^0-9]`)
- `Apache` 라이브러리의 `NumberUtils` 클래스의 `toInt()`
  ```java
  import org.apache.commons.lang3.math.NumberUtils;

  public class Main {
    public static void main(String[] args) {
        String str = "1234";
        int num = NumberUtils.toInt(str);
        System.out.println(num);    // 결과값: 1234

        str = "1234x";
        num = NumberUtils.toInt(str);
        System.out.println(num);    // 결과값: 0
    }
  }
  ```
  + 전달된 문자열에 숫자가 아닌 문자가 포함된 경우 `0` 반환
  + `Integer.parseInt()`의 경우 `NumberFormatException`을 발생시키므로 `toInt()`를 사용하는 것이 안전함
    - `NumberFormatException`이 발생하는 경우
      + 전달된 문자열이 "null"인 경우
      + 전달된 문자열의 길이가 0인 경우
      + 전달된 문자열이 정수 타입이 아닌 경우    
- `Integer.decode()`
  + 형식 : `static Integer decode(String str)`
  + `String`을 `Integer`로 변환
  + 원시(primitive) 값(`int` 타입)을 얻고싶은 경우 `intValue()`와 함께 사용
    ```java
    public class Main {
        public static void main(String[] args) {
            String str = "1234";
            int num = Integer.decode(str);
            System.out.println(num);    // 결과값: 1234

            num = Integer.decode(str).intValue();
            System.out.println(num);    // 결과값: 1234
        }
    }
    ```
    - JDK 1.5부터는 autoBoxing, autoUnBoxing이 적용되므로 굳이 intValue()를 사용할 필요는 없다.
- `Integer.valueOf()`
  + 형식
    - `static Integer valueOf(int n)`
      + int 값을 Integer 인스턴스로 반환
    - `static Integer valueOf(String s)`
      + String 값을 Integer 인스턴스로 반환
    - `static Integer valueOf(String s, int radix)`
      + String 값을 두번째 인수에 지정된 진수의 정수로 반환
- `Integer.parseUnsignedInt()`
  + 형식
    - `static int parseUnsignedInt(String s)`
      + 문자열 인수를 부호 없는 십진 정수로 변환
    - `static int parseUnsignedInt(String s, int radix)`
      + 문자열 인수를 두 번째 인수로 지정된 진수의 부호 없는 정수로 변환

### 2-2. `Integer` 클래스의 `parseInt()` vs `valueOf()`
||parseInt()|valueOf()|
|:---:|:---|:---|
|**매개변수 타입**|문자열|문자열, 정수|
|**반환 타입**|int|Integer|
|**매개변수가 정수인 경우**|오류 발생(호환x)|Integer 객체 반환|
|**매개변수가 문자인 경우**|오류 발생(호환x)|해당 유니코드 반환|
|**성능**|낮음|높음(자주 요청되는 값 캐싱)|
|**언제 사용하는가**|원시 타입인 int 데이터 값이 필요한 경우|Wrapper Integer 객체가 필요한 경우|
<br>

`parseInt()`의 성능이 왜 `valueOf()`보다 낮을까란 궁금증이 생겨 두 메소드의 내부를 뜯어보게 되었다.<br><br>

#### 💻 `parseInt(String s)`
```java
public static int parseInt(String s) throws NumberFormatException {
    return parseInt(s,10);
}
```
음? `parseInt(String s, int radix)`를 내부적으로 리턴하네?<br><br>

#### 💻 `parseInt(String s, int radix)`
```java
public static int parseInt(String s, int radix) throws NumberFormatException {
    /*
        * WARNING: This method may be invoked early during VM initialization
        * before IntegerCache is initialized. Care must be taken to not use
        * the valueOf method.
        */

    if (s == null) {
        throw new NumberFormatException("null");
    }

    if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " greater than Character.MAX_RADIX");
    }

    boolean negative = false;
    int i = 0, len = s.length();
    int limit = -Integer.MAX_VALUE;

    if (len > 0) {
        char firstChar = s.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+') {
                throw NumberFormatException.forInputString(s, radix);
            }

            if (len == 1) { // Cannot have lone "+" or "-"
                throw NumberFormatException.forInputString(s, radix);
            }
            i++;
        }
        int multmin = limit / radix;
        int result = 0;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            int digit = Character.digit(s.charAt(i++), radix);
            if (digit < 0 || result < multmin) {
                throw NumberFormatException.forInputString(s, radix);
            }
            result *= radix;
            if (result < limit + digit) {
                throw NumberFormatException.forInputString(s, radix);
            }
            result -= digit;
        }
        return negative ? result : -result;
    } else {
        throw NumberFormatException.forInputString(s, radix);
    }
}
```
내부적으로 `Character.digit()`메소드를 이용하여 파싱을 하고 있었다.
문자열에 있는 문자 하나하나를 판단해야하기 때문에 문자열이 길다면 성능이 뒤쳐진다는 점이 납득이 간다.
<br><br>

그렇다면 valueOf()는 내부가 어떻길래 성능이 더 낫다는 걸까?
<br>

#### 💻 `valueOf(String s)`
```java
public static Integer valueOf(int i) { 
    if (i >= IntegerCache.low && i <= IntegerCache.high) 
        return IntegerCache.cache[i + (-IntegerCache.low)]; 
    return new Integer(i); 
}
```
`IntegerCache` 클래스는 -128과 127 사이의 값을 autoboxing한 객체의 유일함을 위한 **캐싱 기능**을 지원하는 클래스라고 생각하면 된다. 위의 코드에서도 확인할 수 있듯이, 만약 기존에 생성한 `Integer` 객체 중 동일한 값이 존재한다면 기존 객체를 참조한다. 동일한 값이 존재하지 않는다면 그제서야 `Integer` 객체를 새로 생성하게 된다.

캐싱을 하지 않을 경우, 코드 안에서 초기화가 계속해서 이루어지게 되고, 메모리는 그 횟수만큼 늘어나게 된다. `parseInt()` 메소드가 이러한 이유 때문에 성능이 떨어지게 되는 것. 참으로 비효율적이다😇
<br><br>

결론적으로, 반환값이 원시 타입인지 래퍼 클래스인지 중요하지 않다면 성능 좋은 `valueOf()`를 사용하도록 하자.