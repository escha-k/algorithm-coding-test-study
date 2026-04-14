import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || maps[i].charAt(j) == 'X') {
                    continue;
                }

                answer.add(bfs(i, j, maps, visited));
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        return answer.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int bfs(int sx, int sy, String[] maps, boolean[][] visited) {
        int n = maps.length;
        int m = maps[0].length();
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        int sum = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            sum += Character.getNumericValue(maps[cx].charAt(cy));

            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return sum;
    }
}