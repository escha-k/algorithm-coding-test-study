import java.util.*;

class Solution {
    // 상하좌우 이동을 위한 좌표
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            if (checkRoom(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    private boolean checkRoom(String[] room) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                // 응시자가 앉아있는 위치에서 BFS 시작
                if (room[r].charAt(c) == 'P') {
                    if (!bfs(room, r, c)) return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] room, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 0});
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            // 거리가 2인 지점까지만 확인하면 됨
            if (curr[2] >= 2) continue;

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                    // 파티션을 만나면 그 방향은 탐색 중단
                    if (room[nr].charAt(nc) == 'X') continue;
                    
                    // 빈 테이블이면 탐색 계속 (거리 1 추가)
                    if (room[nr].charAt(nc) == 'O') {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, curr[2] + 1});
                    }
                    
                    // 다른 응시자를 만나면 거리두기 위반
                    if (room[nr].charAt(nc) == 'P') return false;
                }
            }
        }
        return true;
    }
}