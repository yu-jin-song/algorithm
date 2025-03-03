class Solution {
    private static class Block {
        int y, x;
        
        public Block(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private static int N;
    private static boolean[][] board;
    
    public int solution(int n) {
        N = n;
        
        int maxCount = 0;
        for (int col = 0; col < n; col++) {
            board = new boolean[n][n];
            board[0][col] = true;   // 첫 행에 퀸 배치
            if(dfs(1, col)) {
                maxCount++;
            }
        }
        return maxCount;
    }
    
    // 2번째 행부터 마지막 행까지 dfs 진행
    private static boolean dfs(int row, int col) {
        // Block possiblePos = findEmptyPosition(row, col);
        // if (possiblePos == null) {
        //     return true; 
        // }
        
        // int row = possiblePos.y;
        // int col = possiblePos.x;
        
        // for (int y = row; y < N; y++) {
        //     for (int x = col; x < N; x++) {
                if (isValidRange(row, col) && isValid(row, col)) {
                    // 현재 위치에 퀸 배치
                    board[row][col] = true;
                    
                    if (dfs(row + 1, col)) {
                        return true;
                    }
                }
        //     }
        // }
        
        return false;
    }
    
    private static boolean isValid(int row, int col) {
        if (isInRow(row) || isInColumn(col) || isInLeanCross(row, col)) {
            return false;
        }
        return true;
    }
    
    private static boolean isInRow(int row) {
        for (int x = 0; x < N; x++) {
            if (board[row][x]) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isInColumn(int col) {
        for (int y = 0; y < N; y++) {
            if (board[y][col]) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isInLeanCross(int row, int col) {
        if (isValidRange(row, col)) {
            // 좌-상
            boolean leftUp = isInLeanCross(row - 1, col - 1);
            // 우-하
            boolean rightDown = isInLeanCross(row + 1, col + 1);
            
            if (leftUp && rightDown) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isValidRange(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) {
            return true;
        }
        return false;
    }
}