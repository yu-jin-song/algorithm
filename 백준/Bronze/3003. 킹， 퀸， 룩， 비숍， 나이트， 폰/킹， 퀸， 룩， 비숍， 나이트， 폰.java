import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int king = sc.nextInt();
        int queen = sc.nextInt();
        int rook = sc.nextInt();
        int bishop = sc.nextInt();
        int knight = sc.nextInt();
        int pawn = sc.nextInt();
        sc.close();
        
        StringBuilder sb = new StringBuilder();
        sb.append(1 - king).append(" ")
            .append(1 - queen).append(" ")
            .append(2 - rook).append(" ")
            .append(2 - bishop).append(" ")
            .append(2 - knight).append(" ")
            .append(8 - pawn);
        System.out.println(sb);
    }
}