import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String[] matrix = sc.nextLine().split(" ");
        int n = Integer.parseInt(matrix[0]);
        int m = Integer.parseInt(matrix[1]);
        
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        
        setArray(sc, a, n, m);
        setArray(sc, b, n, m);
        sc.close();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(a[i][j]+b[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
    
    static void setArray(Scanner sc, int[][] arr, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
    }
}