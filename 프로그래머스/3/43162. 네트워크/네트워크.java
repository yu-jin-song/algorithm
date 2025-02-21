import java.util.ArrayList;

class Solution {
    // 노드별 방문 여부 표시 배열
    private static boolean[] visited;
    
    private static int[][] linkedArray;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        linkedArray = computers;
        
        int answer = 0;
        for (int node = 0; node < n; node++) {
            // 방문하지 않은 노드라면
            if (!visited[node]) {
                dfs(node); // dfs 수행
                answer++;   // 네트워크 개수 + 1
            }
        }
        return answer;
    }
    
    private void dfs(int node) {
        // 현재 노드 방문 표시
        visited[node] = true;

        for (int next = 0; next < linkedArray[node].length; next++) {
            // 연결된 노드 중 방문하지 않은 노드라면
            if (linkedArray[node][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}