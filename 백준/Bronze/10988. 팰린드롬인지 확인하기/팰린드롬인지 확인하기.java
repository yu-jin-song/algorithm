import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();
        
        int len = word.length();
        int mid = len/2;    // 단어 가운데 인덱스
        int pl = 0;    // 단어 왼쪽 포인터
        int pr = len - 1;    // 단어 오른쪽 포인터
        
        int result = 1;    // 팰린드롬 판별 여부
        for(int i = 0; i <= mid; i++) {
            char left = word.charAt(pl++);
            char right = word.charAt(pr--);
            
            if(left != right) {
                result = 0;
                break;
            }
        }
        
        
        System.out.println(result);
    }
}