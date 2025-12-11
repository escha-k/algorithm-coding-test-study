import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 방문한 길을 저장 Set
        Set<String> visited = new HashSet<>();
        
        // 현재 위치
        int x = 0, y = 0;
        
        for (char dir : dirs.toCharArray()) {
            // 이동 전 위치
            int preX = x;
            int preY = y;
            
            // 명령어에 따라 이동
            if (dir == 'U') y++;
            else if (dir == 'D') y--;
            else if (dir == 'R') x++;
            else if (dir == 'L') x--;
            
            // 경계 체크 (-5 ~ 5)
            if (x < -5 || x > 5 || y < -5 || y > 5) {
                x = preX;
                y = preY;
                continue;
            }
            
            String path1 = preX + "," + preY + "," + x + "," + y;
            String path2 = x + "," + y + "," + preX + "," + preY;
            
            visited.add(path1);
            visited.add(path2);
        }
        
        return visited.size() / 2;
    }
}
