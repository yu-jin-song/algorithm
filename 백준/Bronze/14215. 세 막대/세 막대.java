import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> edges = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            edges.add(sc.nextInt());
        }
        sc.close();
        
        Collections.sort(edges, Collections.reverseOrder());
        
        int a = edges.get(0);
        int b = edges.get(1);
        int c = edges.get(2);
        
        // 가장 긴 변의 길이가 나머지 두 변의 길이의 합보다 작아야 함
        if(a >= b + c) {
            a = b + c - 1;
        }
        
        System.out.println(a + b + c);
    }
}