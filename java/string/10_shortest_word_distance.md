# 9. 숫자만 추출

## ✅ 문제
https://cote.inflearn.com/contest/10/problem/01-09
<br><br>

## 1. 답안 및 풀이
### 1-1. 내 답안
```java
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
  
public class Main {
    public int[] solution(String input) {
        String[] arr = input.split(" ");
        String s = arr[0];
        char t = arr[1].charAt(0);

        int len = s.length();
        
        int[] distance = new int[len];  // 문자 t와 떨어진 거리 기록할 배열
        int last = 0;   // 문자 t가 위치한 마지막 인덱스
        int diff = 0;   // 문자 t와 문자열의 문자간 거리
        
        for(int i=0; i<len; i++) {
            if(arr[0].charAt(i) == t) { // 현재 인덱스의 문자가 문자 t와 동일한 경우
                distance[i] = 0; 
                last = i;
                
                for(int j=i-1; j>=0; j--) { // 문자 t를 기준으로 앞 문자와의 거리 구하기
                    diff = Math.abs(j-last);
                    /* ① 현재 문자가 문자 t와 동일하지 않고
                     * ② 처음으로 문자 t와의 거리를 구하거나
                    ** ③ 기존에 구했던 거리보다 현재 구한 거리가 더 짧은 경우 */
                    if(arr[0].charAt(j) != t && (distance[j] == 0 || distance[j] > diff)) {
                        distance[j] = diff;
                    }
                }
            
                for(int j=i+1; j<len; j++) {    // 문자 t를 기준으로 뒷 문자와의 거리 구하기
                    diff = Math.abs(j-last);
                    if(arr[0].charAt(j) != t && (distance[j] == 0 || distance[j] > diff)) {
                        distance[j] = diff;
                    }
                }
            }

        }

        return distance;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        /* int 배열을 문자열로 변환 후 숫자와 공백을 제외한 나머지 문자를 삭제 */
        String result = Arrays.toString(mc.solution(input)).replaceAll("[^0-9 ]", "");
        System.out.println(result);
    }
}
```
- `Math.abs()`
  + 숫자의 절대값 반환
  + 형식
    - `public static double abs(double number)`
    - `public static float abs(float number)`
    - `public static int abs(int number)`
    - `public static long abs(long number)`

### 1-2. 다른 방법
```java
import java.util.Scanner;
import java.lang.Math;
  
public class Main {
    public int[] solution(String input, char t) {
        int len = input.length();
        int[] distance = new int[len];
        int diff = 1000;
        
        /* 왼쪽에서부터 거리 측정 */
        for(int i=0; i<len; i++) {
            if(input.charAt(i) == t) {  // 문자 t와 동일한 문자일 경우 0
                diff = 0;
            } else {    // 문자 t와 다른 문자일 경우, 문자 t가 등장할 때까지 거리 증가
                diff++;
            }
            distance[i] = diff;
        }

        /*오른쪽에서부터 거리 측정*/
        for(int i=len-1; i>=0; i--) {
            if(input.charAt(i) == t) {
                diff = 0;
            } else {
                diff++;
                distance[i] = Math.min(distance[i], diff);  // 문자간 거리를 기록한 배열의 값과 현재 구한 거리 비교하여 작은 값 대입
            }
        }

        return distance;
    }

    public static void main(String[] args){
        Main mc = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char t = in.next().charAt(0);
        
        for(int x : mc.solution(input, t)) {
            System.out.print(x + " ");
        }
    }
}
```
- `Math` 클래스의 값 비교 메소드 사용

  ||`Math.max()`|`Math.min()`|
  |:---:|:---|:---|
  |**설명**|전달된 두 값을 비교하여 **큰 값** 반환|전달된 두 값을 비교하여 **작은 값** 반환|
  |**형식**|`static double max(double a, double b)`<br>`static float max(float a, float b)`<br>`static int max(int a, int b)`<br>`static long max(long a, long b)`|`static double min(double a, double b)`<br>`static float min(float a, float b)`<br>`static int min(int a, int b)`<br>`static long min(long a, long b)`|

---

## 2. 기록 일지
1. 나는 문자 t를 기준으로 한 번에 앞쪽 문자와 뒤쪽 문자를 비교하는 방법(이하 방법 A)을 사용했는데, 강의에서는 왼쪽에서 오른쪽으로 한 번, 오른쪽에서 왼쪽으로 한 번 비교하는 방법(이하 방법 B)을 사용했다.
실행 속도를 비교했을 때 방법 A가 160ms, 방법 B가 178ms로 방법 A가 좀 더 빨랐다.
그러나 방법 B가 가독성이 더 좋기 때문에 대량의 데이터를 처리할 때 속도 차이가 크지만 않다면 방법 B를 사용할 것 같다.
2. '반복문으로 문자를 출력하는 것보다 문자 배열을 문자열로 변환하여 한 번에 출력하는게 더 낫지 않을까?' 라는 생각에 `Arrays.toString`을 사용하였는데, 그냥 `System.out.print`를 반복문으로 출력하는 게 더 빨랐다. `Arrays` 클래스의 `toString` 메소드 내부를 살펴보면 다음과 같다.

```java
public static String toString(int[] a) {
    if (a == null)
        return "null";
    int iMax = a.length - 1;
    if (iMax == -1)
        return "[]";

    StringBuilder b = new StringBuilder();
    b.append('[');
    for (int i = 0; ; i++) {
        b.append(a[i]);
        if (i == iMax)
            return b.append(']').toString();
        b.append(", ");
    }
}
```

