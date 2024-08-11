import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String testCase = "";
        while(!(testCase = br.readLine()).equals("0 0")) {
            String[] cases = testCase.split(" ");
            int firstNum = Integer.parseInt(cases[0]);
            int secondNum = Integer.parseInt(cases[1]);

            String result = "neither";
            if(firstNum > secondNum) {
            	if(firstNum % secondNum == 0) {
            		result = "multiple";
            	}
            } else {
            	if(secondNum % firstNum == 0) {
            		result = "factor";
            	}
            }
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }
}