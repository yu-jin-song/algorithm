import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        
        int east = -10000;
        int west = 10000;
        int south = 10000;
        int north = -10000;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(x > east) {
                east = x;
            }
            if(x < west) {
                west = x;
            }
            if(y < south) {
                south = y;
            }
            if(y > north) {
                north = y;
            }
        }
        
        int width = east - west;
        int height = north - south;
        
        System.out.println(width * height);
    }
}