import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.close();
        
        StringBuilder sb = new StringBuilder();
        do {
            sb.append("long ");
            n -= 4;
        } while(n > 0);
        
        System.out.println(sb + "int");
    }
}