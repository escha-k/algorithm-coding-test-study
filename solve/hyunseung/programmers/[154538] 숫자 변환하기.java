import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        // dp[i]는 숫자 i를 만들기 위한 최소 연산 횟수
        // y의 최대값이 1,000,000이므로 배열 크기를 y + 1로 설정
        int[] dp = new int[y + 1];
        
        // 초기값은 연산이 불가능함을 나타내는 큰 값(INF)으로 채움
        int INF = 1000001; 
        Arrays.fill(dp, INF);
        
        // 시작점 x는 연산 횟수가 0
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            // 현재 숫자 i에 도달할 수 없는 경우 건너뜀
            if (dp[i] == INF) continue;
            
            // 1. x + n 연산
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            
            // 2. x * 2 연산
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            
            // 3. x * 3 연산
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        
        // y 위치의 값이 초기값(INF) 그대로라면 도달 불가능한 것이므로 -1 반환
        return dp[y] == INF ? -1 : dp[y];
    }
}