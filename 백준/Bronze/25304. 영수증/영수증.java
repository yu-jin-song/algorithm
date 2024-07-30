import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long x = Long.parseLong(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        long totalPrice = 0L;
        for(int i=0; i<n; i++) {
            String[] priceAndCnt = sc.nextLine().split(" ");
            int a = Integer.parseInt(priceAndCnt[0]);
            int b = Integer.parseInt(priceAndCnt[1]);
            totalPrice += a*b;
        }
        
        String result = "No";
        if(totalPrice == x) {
            result = "Yes";
        }
        
        System.out.println(result);
    }
}