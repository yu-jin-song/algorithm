import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());
	
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			
			while(st.hasMoreTokens())
				sum += Integer.parseInt(st.nextToken());
			
			bw.write(sum + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
