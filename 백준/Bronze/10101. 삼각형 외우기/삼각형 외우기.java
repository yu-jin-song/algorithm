import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int n3 = Integer.parseInt(sc.nextLine());
        
        sc.close();
        
        int sum = n1 + n2 + n3;
        if(sum != 180) {
            System.out.println("Error");
        } else {
        	if(n1 == 60 && n2 == 60 && n3 == 60) {
                System.out.println("Equilateral");
            } else if(n1 != n2 && n2 != n3 && n3 != n1) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}