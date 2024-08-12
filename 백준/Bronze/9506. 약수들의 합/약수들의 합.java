import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.StringBuilder;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = 0;
        while((n = Integer.parseInt(br.readLine())) != -1) {
            List<Integer> factors = new ArrayList<>();
            int total = 0;
            for(int i = 1; i < n; i++) {
                if(n%i == 0) {
                    factors.add(i);
                    total += i;
                }
            }
            
            if(total != n) {
                sb.append(n).append(" is NOT perfect.\n");
            } else {
                sb.append(n).append(" = ");
                int len = factors.size();
                for(int i = 0; i < len; i++) {
                    sb.append(factors.get(i));
                    if(i != len - 1) {
                        sb.append(" + ");
                    }
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}