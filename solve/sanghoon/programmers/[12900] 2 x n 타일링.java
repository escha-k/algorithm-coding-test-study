class Solution {
    static final int R = 1_000_000_007;

    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % R;
        }

        return dp[n];
    }
}