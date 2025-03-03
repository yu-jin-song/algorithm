class Solution {
    private static int N;
    private static boolean[] queen;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;
    private static int maxCount;
    
    public int solution(int n) {
        N = n;
        queen = new boolean[N];
        diagonal1 = new boolean[N*2];
        diagonal2 = new boolean[N*2];
        maxCount = 0;
        dfs(0);
        return maxCount;
    }
    
    private static void dfs(int row) {
        if (row == N) {
            maxCount++;
            return;
        }
        
        // ↘
        // 0 -> 2 -> 4 -> 6 {(0,0),(1,1),(2,2),(3,3)}
        // 1 -> 3 -> 5  {(1,0),(2,1),(3,2)}
        // (0,0) -> 2-1+4
        for (int col = 0; col < N; col++) {
            if (queen[col] || diagonal1[row+col] || diagonal2[col-row+N]) {
                continue;
            }
            
            // 퀸 배치, 우상-좌하↙ 대각선, 좌상-우하↘ 대각선 존재 표시
            queen[col] = diagonal1[row+col] = diagonal2[col-row+N] = true;
            // 다음행 탐색
            dfs(row+1);
            // 백트래킹
            queen[col] = diagonal1[row+col] = diagonal2[col-row+N] = false;
        }
    }
}