import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        
        int[] boxes = new int[n+1];
        for(int i = 1; i <= n; i++) {
            boxes[i] = i;
        }
        
        for(int seq = 0; seq < m; seq++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            sc.nextLine();
            
            for(int idx = i; idx <= j; idx++) {
                int temp = boxes[idx];
                boxes[idx] = boxes[j];
                boxes[j] = temp;
                j--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(boxes[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }
}