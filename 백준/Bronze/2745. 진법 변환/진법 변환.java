import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> bases = new ArrayList<>();
        
        String[] baseInput = sc.nextLine().split(" ");
        sc.close();
        
        int b = Integer.parseInt(baseInput[1]);
        char preAlphabet = 'A'; 
        for(int i = 0; i <= b; i++) {
            if(i > 9) {
                bases.add(String.valueOf(preAlphabet++));
            } else {
                bases.add(String.valueOf(i));
            }
        }
        
        int len = baseInput[0].length() - 1;
        int n = 0;
        int basePow = 0;
        for(int i = len; i >= 0; i--) {
            char c = baseInput[0].charAt(i);
            int num = 0;
           
            // 숫자인 경우
            if(Character.isDigit(c)) {
                num = Integer.parseInt(String.valueOf(c));
            }
            
            // 문자인 경우
            if(bases.contains(String.valueOf(c))) {
                num = bases.indexOf(String.valueOf(c));
            }
            
            n += num*Math.pow(b, basePow++);
        }
        
        System.out.println(n);
    }
}