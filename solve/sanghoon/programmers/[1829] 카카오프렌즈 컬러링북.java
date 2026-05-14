import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int num = 0;
        int maxSize = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) {
                    continue;
                }

                int count = bfs(i, j, picture, visited);
                num++;
                maxSize = Math.max(maxSize, count);
            }
        }

        return new int[]{num, maxSize};
    }

    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int bfs(int sx, int sy, int[][] map, boolean[][] visited) {
        int m = map.length;
        int n = map[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int startColor = map[sx][sy];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n ||
                    visited[nx][ny] || map[nx][ny] != startColor) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }

        return count;
    }
}