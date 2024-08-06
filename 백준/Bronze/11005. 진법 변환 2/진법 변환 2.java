import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String[] baseInput = sc.nextLine().split(" ");
        sc.close();
        
        int b = Integer.parseInt(baseInput[1]);
        
        // 진법에 따른 표기 저장
        List<String> bases = new ArrayList<>();
        char alphabet = 'A';
        for(int i = 0; i <= b; i++) {
            if(i < 10) {
                bases.add(String.valueOf(i));
            } else {
                bases.add(String.valueOf(alphabet++));
            }
        }
        
        // 10진수를 B진수로 변환
        int n = Integer.parseInt(baseInput[0]);
        List<String> convertSaver = new ArrayList<>();
        while(n >= b) {
            int mod = n%b;
            n /= b;
            if(mod >= 10) {
                convertSaver.add(bases.get(mod));
            } else {
                convertSaver.add(String.valueOf(mod));
            }
        }
        
        // 맨 마지막에는 몫을 추가
        if(n >= 10) {
            convertSaver.add(bases.get(n));
        } else {
            convertSaver.add(String.valueOf(n));
        }
        
        // 리스트에 저장된 마지막 요소부터 출력
        int len = convertSaver.size() - 1;
        for(int i = len; i >= 0; i--) {
            sb.append(convertSaver.get(i));
        }
        
        System.out.println(sb);
    }
}