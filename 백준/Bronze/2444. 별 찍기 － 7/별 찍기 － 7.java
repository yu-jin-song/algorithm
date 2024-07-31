import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
        int n = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
        	sb.append(print(n, i));
            sb.append("\n");
        }
        
        for(int i = n-1; i > 0; i--) {
        	sb.append(print(n, i));
            sb.append("\n");
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1));
	}
	
	static StringBuilder print(int n, int i) {
		StringBuilder sb = new StringBuilder();
		
		for(int j = n ; j > i; j--) {
    		sb.append(" ");
    	}
		
		for(int j = 0; j < (2*i - 1); j++) {
        	sb.append("*");
        }
        
        return sb;
	}
}