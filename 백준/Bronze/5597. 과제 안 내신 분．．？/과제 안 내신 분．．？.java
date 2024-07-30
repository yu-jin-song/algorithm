import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean[] submits = new boolean[31];
        for(int i = 0; i < 28; i++) {
            int number = Integer.parseInt(sc.nextLine());
            submits[number] = true;
        }
        
        for(int i = 1; i < submits.length; i++) {
            if(!submits[i]) {
                System.out.println(i);
            }
        }
    }
}