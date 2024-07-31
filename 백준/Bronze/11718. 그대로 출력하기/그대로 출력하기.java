import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        do {
            sb.append(sc.nextLine());
            sb.append("\n");
        } while(sc.hasNextLine());
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }
}