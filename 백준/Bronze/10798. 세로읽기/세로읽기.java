import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String[] words = new String[5];
        int[] lenArr = new int[5];
        int maxLen = 0;
        
        for(int i = 0; i < 5; i++) {
            words[i] = sc.nextLine();
            lenArr[i] = words[i].length();
            if(lenArr[i] > maxLen) {
            	maxLen = lenArr[i];
            }
        }
        sc.close();
        
        for(int i = 0; i < maxLen; i++) {
            for(int j = 0; j < 5; j++) {
            	if(lenArr[j] > i) {
            		sb.append(words[j].charAt(i));
            	}
            }
        }
        
        System.out.println(sb);
    }
}