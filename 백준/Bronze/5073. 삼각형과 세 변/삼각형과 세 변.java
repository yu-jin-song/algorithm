import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = "";
        List<Integer> numbers = null;
        while(!(input = br.readLine().trim()).equals("0 0 0")) {
            String[] inputs = input.split(" ");
            numbers = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                numbers.add(Integer.parseInt(inputs[i]));
            }
            
            Collections.sort(numbers, Collections.reverseOrder());
            int n1 = numbers.get(0);
            int n2 = numbers.get(1);
            int n3 = numbers.get(2);
            if(n1 >= n2 + n3) {
                bw.write("Invalid");
            } else {
                if(n1 == n2 && n2 == n3 && n3 == n1) {
                	bw.write("Equilateral");
                } else {
                    if(n1 != n2 && n2 != n3 && n3 != n1) {
                    	bw.write("Scalene");
                    } else {
                    	bw.write("Isosceles");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}