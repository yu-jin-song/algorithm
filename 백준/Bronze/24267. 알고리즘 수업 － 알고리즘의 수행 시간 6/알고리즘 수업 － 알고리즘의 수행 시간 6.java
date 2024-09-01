import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        sc.close();
        
        long cnt = 0l;
        for(long i = n - 2; i >= 1; i--) {
            cnt += (1 + i)*i/2;
        }
        System.out.println(cnt);
        System.out.println("3");

    }
}