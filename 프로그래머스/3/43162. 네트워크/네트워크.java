// 간접 연결되어있을때도 같은 네트워크 상에 있는 것으로 간주 => DFS?
// 무방향 그래프

import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    // n: 컴퓨터의 개수(1 ~ 200), 번호는 0 ~ n-1
    // computers: 연결에 대한 정보가 담긴 배열([i][j]: i번 컴퓨터와 j번 컴퓨터가 연결되어 있음)
    public int solution(int n, int[][] computers) {
        // 각 컴퓨터에 연결된 컴퓨터 리스트 배열
        ArrayList<Integer>[] connects = new ArrayList[n];
        // 연결 리스트 초기화
        for (int i = 0; i < n; i++) {
            connects[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                // 자기 자신을 포함한 연결된 컴퓨터가 존재하면
                if (computers[i][j] == 1) {
                    connects[i].add(j); // 현재 노드의 연결 리스트에 추가
                }
            }
        }
        
        // 방문 여부 표시
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            // 이미 방문한 노드라면 skip
            if (visited[i]) {
                continue;
            }
            
            // 큐 생성
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(i); // 시작 노드 큐에 추가
            visited[i] = true;   // 방문했음을 표시
            int cnt = 1;    // 현재 노드를 기준으로 방문한 노드 개수 저장할 변수

            // 큐가 비어있지 않은 동안
            while(!queue.isEmpty()) {
                // 현재 노드 가져오기
                int current = queue.pollFirst();

                // 현재 노드와 연결된 노드들 가져오기
                for (int connect : connects[current]) {
                    // 방문한 노드가 아니라면
                    if (!visited[connect]) {
                        queue.add(connect); // 큐에 연결 노드 추가
                        visited[connect] = true;    // 연결 노드 방문 표시
                        cnt++;
                    }
                }
            }
            
            // 네트워크 개수 증가
            if (cnt != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}