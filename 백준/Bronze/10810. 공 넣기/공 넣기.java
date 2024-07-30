import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numbers = sc.nextLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        
        int[] boxes = new int[n+1];
        for(int seq = 0; seq < m; seq++) {
            String[] standard = sc.nextLine().split(" ");
            int i = Integer.parseInt(standard[0]);    // 바구니 시작 번호
            int j = Integer.parseInt(standard[1]);    // 바구니 종료 번호
            int k = Integer.parseInt(standard[2]);    // 공 번호
            
            for(int idx = i; idx <= j; idx++) {
                boxes[idx] = k;
            }
        }
        
        String result = "";
        for(int i = 1; i < boxes.length; i++) {
            result += boxes[i] + " ";
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }
}