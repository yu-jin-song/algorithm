class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 행렬 곱셈 크기 : A(M,N) x B(N,O) = M x O
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        int[][] answer = new int[row1][col2];
        
        for (int i = 0; i < row1; i++) { // arr1의 행
            for (int j = 0; j < col2; j++) {  // arr1의 열
                for (int k = 0; k < col1; k++) { // arr2의 행
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}