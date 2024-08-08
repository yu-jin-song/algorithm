import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int[] exchangeCnts = {25, 10, 5, 1};
        
        int T = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < T; i++) {
            int C = Integer.parseInt(sc.nextLine());
            
            for(int j = 0; j < 4; j++) {
                sb.append(C / exchangeCnts[j]).append(" ");
                C %= exchangeCnts[j];
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        sc.close();
        
        System.out.println(sb);
    }
}