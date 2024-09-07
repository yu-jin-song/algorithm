import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] participants = sc.nextLine().split(" ");
        int N = Integer.parseInt(participants[0]);
        int k = Integer.parseInt(participants[1]);
        
        int[] scores = new int[N];
        int length = scores.length;
        for(int i = 0; i < length; i++) {
            scores[i] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(scores);
        System.out.println(scores[length - k]);
    }
}