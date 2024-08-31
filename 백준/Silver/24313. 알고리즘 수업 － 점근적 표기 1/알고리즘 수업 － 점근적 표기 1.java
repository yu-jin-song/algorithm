import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] a = sc.nextLine().split(" ");
        int a1 = Integer.parseInt(a[0]);
        int a0 = Integer.parseInt(a[1]);
        
        int c = Integer.parseInt(sc.nextLine());
        int n0 = Integer.parseInt(sc.nextLine());
        sc.close();
        
        if (a1*n0 + a0 <= c * n0 && a1 <= c) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}