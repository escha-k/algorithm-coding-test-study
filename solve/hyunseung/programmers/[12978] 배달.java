class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1. 거리 배열 초기화 (충분히 큰 값 사용)
        int[][] dist = new int[N + 1][N + 1];
        int INF = 500001; // K의 최대값이 500,000이므로 그보다 큰 값

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // 2. 도로 정보 입력 (동일 경로 중 최솟값 저장)
        for (int[] r : road) {
            int a = r[0], b = r[1], w = r[2];
            if (dist[a][b] > w) {
                dist[a][b] = w;
                dist[b][a] = w;
            }
        }

        // 3. 플로이드-워셜 수행
        for (int k = 1; k <= N; k++) { // 거쳐가는 마을
            for (int i = 1; i <= N; i++) { // 출발 마을
                for (int j = 1; j <= N; j++) { // 도착 마을
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 4. 1번 마을에서 K 이하 거리인 마을 카운트
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[1][i] <= K) answer++;
        }

        return answer;
    }
}