import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] time = sc.nextLine().split(" ");
        int a = Integer.parseInt(time[0]);
        int b = Integer.parseInt(time[1]);
        int c = sc.nextInt();
        
        int minute = b+c;
        if(minute >= 60) {
            a += (minute / 60);
            minute %= 60;
        }
        if(a >= 24) {
            a -= 24;
        }
        
        System.out.println(a + " " + minute);
    }
}