import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.close();
        
        long perimeter = 0L;
        // 정사각형 한 변의 길이 1, 둘레 4
        for(int i = 1; i <= n; i++) {
            perimeter += 3;    // 윗변 : 0.5 + 0.5, 옆변 : 1 + 1
        }
        perimeter += n;
        
        System.out.println(perimeter);
    }
}