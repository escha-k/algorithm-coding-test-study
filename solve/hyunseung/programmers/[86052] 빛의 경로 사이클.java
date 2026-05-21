import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        int R = grid.length;
        int C = grid[0].length(); 
        
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        boolean[][][] visited = new boolean[R][C][4];
        List<Integer> answerList = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    
                    
                    if (!visited[r][c][d]) {
                        int length = 0;
                        int currR = r;
                        int currC = c;
                        int currD = d;

                        while (!visited[currR][currC][currD]) {
                            visited[currR][currC][currD] = true;
                            length++;

                            char ch = grid[currR].charAt(currC);
                            if (ch == 'L') {
                                currD = (currD + 3) % 4; 
                            } else if (ch == 'R') {
                                currD = (currD + 1) % 4; 
                            }

                            
                            currR = (currR + dr[currD] + R) % R;
                            currC = (currC + dc[currD] + C) % C;
                        }
                        answerList.add(length);
                    }
                    
                }
            }
        }

        
        Collections.sort(answerList);
        
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}