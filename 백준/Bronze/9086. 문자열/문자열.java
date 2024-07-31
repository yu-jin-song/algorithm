import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            String str = sc.nextLine();
            
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length() - 1));
            sb.append("\n");
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}