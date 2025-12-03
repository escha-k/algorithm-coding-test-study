import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;     
        int m = maps[0].length;   
        
        // 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS를 위한 Queue (x, y, 거리)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        
        // 방문 체크
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 목적지 도착
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            // 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 방문 가능한 경우 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        // 도착 실패
        return -1;
    }
}
