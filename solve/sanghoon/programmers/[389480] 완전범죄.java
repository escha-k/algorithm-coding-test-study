import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = 10_000;

        // dp[x]: B의 흔적이 x일 때의 A의 흔적의 최소값
        int[] dp = new int[m]; // 0 ~ m-1
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] in : info) {
            int a = in[0];
            int b = in[1];

            // 역순으로 계산
            for (int i = m - 1; i >= 0; i--) {
                // 현재 상태에서 B가 훔치는 경우
                if (i + b < m) {
                    dp[i + b] = Math.min(dp[i + b], dp[i]);
                }

                // 현재 상태에서 A가 훔치는 경우
                dp[i] = dp[i] + a;
            }
        }

        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[i]);
        }

        return answer >= n ? -1 : answer;
    }
}