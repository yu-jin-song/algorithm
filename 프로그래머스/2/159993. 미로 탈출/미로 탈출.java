//벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다.
//통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. => BFS
//아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다.
// 시작 -> 레버까지의 최단 경로 + 레버 -> 출구까지의 최단 경로

import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    private static class Map {
        int y, x;
        
        public Map(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private static int ROW_SIZE;
    private static int COL_SIZE;
    
    private static char[][] maze;
    
    // maps: 미로를 나타낸 문자열
    public int solution(String[] maps) {
        // 직사각형 => 가로와 세로 길이가 다를 수 있음
        ROW_SIZE = maps.length;
        COL_SIZE = maps[0].length();
        
        maze = new char[ROW_SIZE][COL_SIZE];
        
        // 시작 지점, 레버, 목적지
        Map start = null;
        Map lever = null;
        Map dest = null;
        
        for (int row = 0; row < ROW_SIZE; row++) {
            char[] map = maps[row].toCharArray();
            for (int col = 0; col < COL_SIZE; col++) {
                char state = map[col];
                maze[row][col] = state;
                
                if (state == 'S') {
                    start = new Map(row, col);
                }
                if (state == 'L') {
                    lever = new Map(row, col);
                }
                if (state == 'E') {
                    dest = new Map(row, col);
                }
            }
        }
        
        // 출발점 -> 레버
        int startToLever = bfs(start, lever);
        // 레버 -> 도착점
        int leverToDest = bfs(lever, dest);
        
        if (startToLever == -1 || leverToDest == -1) {
            return -1;
        }
        
        // 출발점 -> 레버 -> 도착점 최단 경로 반환
        return startToLever + leverToDest;
    }
    
    // 상,하,좌,우
    private static int[] moveY = {-1, 1, 0, 0};
    private static int[] moveX = {0, 0, -1, 1};
    
    private int bfs(Map start, Map dest) {
        // 경로 거리 저장
        int[][] distance = new int[ROW_SIZE][COL_SIZE];
        
        ArrayDeque<Map> queue = new ArrayDeque<>();
        queue.add(start);
        distance[start.y][start.x] = 0;
        
        while (!queue.isEmpty()) {
            Map current = queue.pollFirst();
            
            for (int i = 0; i < moveY.length; i++) {
                int ny = current.y + moveY[i];
                int nx = current.x + moveX[i];
                
                // 맵의 범위를 벗어나는 경우 skip
                if (ny < 0 || nx < 0 || ny >= ROW_SIZE || nx >= COL_SIZE) {
                    continue;
                }
                
                // 이미 방문한 경우 skip
                if (distance[ny][nx] > 0) {
                    continue;
                }
                
                // 벽인 경우 skip
                if (maze[ny][nx] == 'X') {
                    continue;
                }
                
                distance[ny][nx] = distance[current.y][current.x] + 1;
                
                // 도착지라면
                if (ny == dest.y && nx == dest.x) {
                    return distance[ny][nx];
                }
                
                queue.add(new Map(ny, nx));
            }
        }
        
        // 도달 못한 경우 -1 반환
        return -1;
    }
}