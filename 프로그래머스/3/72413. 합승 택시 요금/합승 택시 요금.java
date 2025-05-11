import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    private static class Node {
        int dest, cost; // 도착노드, 비용
        
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    private static int N;
    private static ArrayList<Node>[] nextNodes;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        
        nextNodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nextNodes[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            nextNodes[fare[0]].add(new Node(fare[1], fare[2]));
            nextNodes[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        int[] sCost = search(s);    // 시작지점부터 각 노드까지의 비용
        int[] aCost = search(a);    // a 지점부터 각 노드까지의 비용
        int[] bCost = search(b);    // b 지점부터 각 노드까지의 비용
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 현재까지의 비용과 시작지점, a지점, b지점에서 현재 노드까지의 비용 중 적은 값으로 갱신
            min = Math.min(min, sCost[i] + aCost[i] + bCost[i]);
        }
        
        return min;
    }
    
    private static int[] search(int start) {
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;    // 시작 지점의 비용은 0=
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));  // 시작 노드 설정
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 현재 경로까지의 비용이 단순 비용보다 작다면 skip 
            if (cost[current.dest] < current.cost) {
                continue;
            }
            
            for (Node next : nextNodes[current.dest]) {
                // if (!visited[next.dest]) {  // 방문하지 않은 노드인 경우만
                    int newCost = cost[current.dest] + next.cost;
                    
                    // 새 비용이 현재 비용보다 저렴하다면
                    if (newCost < cost[next.dest]) {
                        cost[next.dest] = newCost;
                        queue.add(new Node(next.dest, cost[next.dest]));
                    }
                // }
            }
        }
        
        return cost;
    }
}