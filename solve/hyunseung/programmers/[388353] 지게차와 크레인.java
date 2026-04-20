import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] map = new char[n + 2][m + 2];

        // 1. 테두리를 포함한 맵 초기화 (0은 빈 공간)
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '0');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);
            List<int[]> targets = new ArrayList<>();

            if (req.length() == 1) { // 지게차
                // 외부와 연결된 빈 공간 찾기 (BFS)
                boolean[][] accessible = getAccessible(map, n, m);
                
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= m; c++) {
                        if (map[r][c] == target) {
                            for (int d = 0; d < 4; d++) {
                                if (accessible[r + dr[d]][c + dc[d]]) {
                                    targets.add(new int[]{r, c});
                                    break;
                                }
                            }
                        }
                    }
                }
            } else { // 크레인
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= m; c++) {
                        if (map[r][c] == target) {
                            targets.add(new int[]{r, c});
                        }
                    }
                }
            }

            // 출고 처리 (빈 공간 '0'으로 변경)
            for (int[] pos : targets) {
                map[pos[0]][pos[1]] = '0';
            }
        }

        // 2. 남은 컨테이너 개수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '0') answer++;
            }
        }
        return answer;
    }

    // 외부(0,0)에서 도달 가능한 빈 공간을 체크하는 BFS
    private boolean[][] getAccessible(char[][] map, int n, int m) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr >= 0 && nr < n + 2 && nc >= 0 && nc < m + 2) {
                    if (!visited[nr][nc] && map[nr][nc] == '0') {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return visited;
    }
}