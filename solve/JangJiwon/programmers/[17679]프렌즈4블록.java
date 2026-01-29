class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        
        while (true) {
            boolean[][] toRemove = new boolean[m][n];
            int removeCount = mark(map, toRemove, m, n);
            
            if (removeCount == 0) break;
            answer += remove(map, toRemove, m, n);
            drop(map, m, n);
        }
        return answer;
    }
    
    int mark(char[][] map, boolean[][] toRemove, int m, int n) {
        int count = 0;
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char block = map[i][j];
                
                if (block != '0' &&
                    block == map[i][j+1] &&
                    block == map[i+1][j] &&
                    block == map[i+1][j+1]) {
                    
                    toRemove[i][j] = true;
                    toRemove[i][j+1] = true;
                    toRemove[i+1][j] = true;
                    toRemove[i+1][j+1] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int remove(char[][] map, boolean[][] toRemove, int m, int n) {
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toRemove[i][j]) {
                    map[i][j] = '0';
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void drop(char[][] map, int m, int n) {
        for (int j = 0; j < n; j++) {
            int bottom = m - 1;  
            
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] != '0') {
                    char temp = map[i][j];
                    map[i][j] = '0';
                    map[bottom][j] = temp;
                    bottom--;
                }
            }
        }
    }
}
