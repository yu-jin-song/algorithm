import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static String[][] Tickets;
    private static int n;
    private static ArrayList<String> paths; // 경로 저장 list
    private static boolean[] used;   // 티켓 사용 여부
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        Tickets = tickets;
        
        paths = new ArrayList<>();
        used = new boolean[n];
        
        dfs(0, "ICN", "ICN");
        
        // 오름차순으로 경로 정렬
        Collections.sort(paths);
        
        return paths.get(0).split(",");
    }
    
    // cnt: 사용한 티켓 수, departure: 출발지, path: 현재까지의 경로
    private static void dfs(int cnt, String departure, String path) {
        if (cnt == n) { // 티켓을 모두 사용했다면
            paths.add(path);    // 경로를 저장한다.
        } else {
            for (int i = 0; i < n; i++) {
                // 사용하지 않은 티켓이고, 출발지가 티켓의 출발지와 같다면
                if (!used[i] && Tickets[i][0].equals(departure)) {
                    used[i] = true;
                    // 티켓 사용 개수를 증가시키고, 도착지를 다음 출발지로 지정, 현재까지의 경로를 설정한다.
                    dfs(cnt + 1, Tickets[i][1], path + "," + Tickets[i][1]);
                    used[i] = false;
                }
            }
        }
    }
}