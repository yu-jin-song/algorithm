import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        long V = sc.nextLong();
        sc.close();
        
        // 1. 마지막 날 낮에 올라갈 높이를 제외한 높이 필요
        // 2. (V - A) / (A - B) 가 나누어 떨어지지 않으면 하루가 더 필요하므로 올림을 해줌
        // 3. 마지막 날을 더해줘야 함
        double day = Math.ceil((double)(V - A)/(A - B)) + 1.0;
        
        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(day));
    }
}
