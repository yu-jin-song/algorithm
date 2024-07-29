import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        sc.close();
        
        int reward = 0;
        
        // 같은 눈이 3개가 나오는 경우
        if (a == b && b == c && a == c) {
            reward = 10000 + a * 1000;
        }// 모두 다른 눈이 나오는 경우
        else if (a != b && b != c && a != c) {
            int max = 0;
            if (a > max) {
                max = a;
            }
            if (b > max) {
                max = b;
            }
            if (c > max) {
                max = c;
            }
            
            reward = max * 100;
        }
        // 같은 눈이 2개만 나오는 경우
        else {
            int same = (a == b || a == c) ? a : b;
            reward = 1000 + same * 100;
        }
        
        System.out.println(reward);
    }
}