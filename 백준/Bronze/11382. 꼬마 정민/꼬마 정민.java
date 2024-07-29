import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String[] numbers = sc.nextLine().split(" ");
        long a = Long.parseLong(numbers[0]);
        long b = Long.parseLong(numbers[1]);
        long c = Long.parseLong(numbers[2]);
        
        System.out.println(a + b + c);
    }
}