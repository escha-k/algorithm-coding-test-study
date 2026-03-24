import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] start = null, lever = null, exit = null;
        
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                char c = maps[i].charAt(j);
                if(c == 'S') start = new int[]{i,j};
                else if(c == 'L') lever = new int[]{i,j};
                else if(c == 'E') exit = new int[]{i,j};
            }
        }
        
        int dist1 = bfs(maps, start, lever);
        if(dist1 == -1) return -1;
        
        int dist2 = bfs(maps, lever, exit);
        if(dist2 == -1) return -1;
        
        return dist1 + dist2;
    }
    
    int bfs(String[] maps, int[] start, int[] end){
        int n = maps.length;
        int m = maps[0].length();
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == end[0] && y == end[1]) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1}); 
                }
            }
        }
        return -1; 
    }  
}  
