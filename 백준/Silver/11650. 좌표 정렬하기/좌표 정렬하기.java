import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] points = br.readLine().split(" ");
            int x = Integer.parseInt(points[0]);
            int y = Integer.parseInt(points[1]);
            
            List<Integer> pointY = positions.containsKey(x) ?
                positions.get(x) : new ArrayList<>();
            pointY.add(y);
            
            positions.put(x, pointY);
        }
        
        List<Integer> keySet = new ArrayList<>(positions.keySet());
        Collections.sort(keySet);
        
        for(int i = 0; i < keySet.size(); i++) {
        	int x = keySet.get(i);
        	List<Integer> pointY = positions.get(x);
        	Collections.sort(pointY);
        	for(int j = 0; j < pointY.size(); j++) {
        		bw.write(keySet.get(i) + " " + pointY.get(j) + "\n");
        	}       	
        }
        
        bw.flush();
        bw.close();
    }
}