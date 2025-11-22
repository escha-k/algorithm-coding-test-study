class Solution {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];

        dfs(k, dungeons, 0);

        return answer;
    }

    // k : 현재 피로도
    // count : 지금까지 탐험한 던전 수
    private void dfs(int k, int[][] dungeons, int count) {
        // 현재까지 탐험한 개수로 최대값 갱신
        if (count > answer) {
            answer = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0]; // 최소 필요 피로도
            int cost = dungeons[i][1]; // 소모 피로도

            // 아직 방문 안 했고, 들어갈 수 있는 던전이면
            if (!visited[i] && k >= required) {
                visited[i] = true; // 방문 표시
                dfs(k - cost, dungeons, count + 1); // 피로도 차감하고 다음 탐색
                visited[i] = false; // 원상 복구 (백트래킹)
            }
        }
    }
}
