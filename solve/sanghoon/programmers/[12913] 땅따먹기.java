class Solution {
    private static final int COLUMN = 4;

    int solution(int[][] land) {
        int row = land.length;
        int[][] dp = new int[row][COLUMN];

        // 첫 줄 초기화
        for (int i = 0; i < COLUMN; i++) {
            dp[0][i] = land[0][i];
        }

        // bottom-up DP
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < COLUMN; j++) {
                for (int k = 0; k < COLUMN; k++) {
                    if (j == k) continue; // 이전칸과 같은 열은 밟을 수 없음
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        // dp배열 마지막행의 최댓값 구하기
        int answer = 0;
        for (int i = 0; i < COLUMN; i++) {
            answer = Math.max(answer, dp[row - 1][i]);
        }

        return answer;
    }
}