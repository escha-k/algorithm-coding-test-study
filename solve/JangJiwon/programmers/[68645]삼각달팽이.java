import java.util.*;
class Solution {
    public int[] solution(int n) {
        // 삼각형
        int[][] triangle = new int[n][n];
        
        int in = 1; // 채울 숫자
        int x = 0, y = 0;  // 현재 위치
        int dir = 0;    // 방향
        
        // 방향 벡터
        int[] dx =  {1,0,-1};
        int[] dy = {0,1,-1};
        
        triangle[0][0] = in;
        in++;
        while(in <= n*(n+1)/2){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny <= nx && triangle[nx][ny] == 0){
                x = nx;
                y = ny;
                triangle[x][y] = in++;
            } else {
                dir = (dir+1)%3;
            }
        }
        
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j =0;j<=i;j++){
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}
