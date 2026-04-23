import java.util.*;

class Solution {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        Map<Integer, Integer> idMap = new HashMap<>(); // 각 덩어리의 석유량
        List<Set<Integer>> idSets = new ArrayList<>(); // 각 열이 포함하는 덩어리 종류
        for (int i = 0; i < m; i++) {
            idSets.add(new HashSet<>());
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                // bfs
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int cx = cur[0];
                    int cy = cur[1];
                    idMap.merge(id, 1, Integer::sum);
                    idSets.get(cy).add(id);

                    for (int[] d : dirs) {
                        int nx = cx + d[0];
                        int ny = cy + d[1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m
                            || land[nx][ny] == 0 || visited[nx][ny]) {
                            continue;
                        }

                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                id++;
            }
        }

        int answer = 0;
        for (Set<Integer> set : idSets) {
            int sum = 0;
            for (int e : set) {
                sum += idMap.get(e);
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}