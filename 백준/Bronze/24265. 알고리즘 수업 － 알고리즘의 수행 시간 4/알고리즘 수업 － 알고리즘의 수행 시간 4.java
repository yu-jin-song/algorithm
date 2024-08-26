import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        sc.close();
        
        // 등차수열 : (첫째항 + 마지막항)*항의 갯수 / 2
        long sum = (1 + (n - 1))*(n - 1) / 2;
        System.out.println(sum);
        System.out.println("2");
    }
}