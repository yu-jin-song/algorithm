import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
	static char[][] board;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] cnts = br.readLine().split(" ");
        int N = Integer.parseInt(cnts[0]);
        int M = Integer.parseInt(cnts[1]);
        board = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	board[i] = br.readLine().toCharArray();
        }
        
        int minCnt = Integer.MAX_VALUE;
        for(int i = 0; N - i >= 8; i++) {
        	for(int j = 0; M - j >= 8; j++) {
        		int cnt = processCount(i, j);
        		minCnt = Math.min(cnt, minCnt);
        	}
        }
        
        System.out.println(minCnt);
    }
    
    static int processCount(int startN, int startM) {
    	// 맨 왼쪽 상단의 색상을 두 가지 경우로 나누어서 확인(W, B)
    	int whiteStartCnt = 0;
    	int blackStartCnt = 0;
    	
    	char[][] workArrays = new char[8][8];
    	for(int i = 0; i < 8; i++) {
    		// 깊은 복사로 현재 행의 작업 배열 생성
	    	workArrays[i] = Arrays.copyOfRange(board[startN + i], startM, startM + 8);
			
	    	for(int j = 0; j < 8; j++) {
                //좌표를 더하여 칸의 홀/짝 여부 확인 가능
	    		if((i + j)%2 == 0) {
	    			whiteStartCnt += workArrays[i][j] == 'B' ? 1 : 0;
	    			blackStartCnt += workArrays[i][j] == 'W' ? 1 : 0;
	    		} else {
	    			whiteStartCnt += workArrays[i][j] == 'W' ? 1 : 0;
	    			blackStartCnt += workArrays[i][j] == 'B' ? 1 : 0;
	    		}
	    	}
    	}
    	
    	return Math.min(whiteStartCnt, blackStartCnt);
    }
}