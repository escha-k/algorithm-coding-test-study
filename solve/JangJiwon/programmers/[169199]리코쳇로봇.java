import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        // R, G 위치 찾기
        int[] start = null, goal = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[]{i, j};
                } else if (board[i].charAt(j) == 'G') {
                    goal = new int[]{i, j};
                }
            }
        }
        
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == goal[0] && y == goal[1]) {
                return dist;
            }
            
            // 4방향 미끄러지기
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                
                // 끝까지
                while (true) {
                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];
                    
                    if (nnx < 0 || nnx >= n || nny < 0 || nny >= m 
                        || board[nnx].charAt(nny) == 'D') {
                        break;
                    }
                    
                    nx = nnx;
                    ny = nny;
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }
}
