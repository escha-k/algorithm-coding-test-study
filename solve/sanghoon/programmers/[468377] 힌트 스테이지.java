class Solution {

    int n;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;

        dfs(0, 0, new int[n], cost, hint);

        return answer;
    }

    void dfs(int idx, int currentCost, int[] hintCount, int[][] cost, int[][] hint) {
        if (currentCost >= answer) {
            return;
        }

        if (idx == hint.length) {
            int total = currentCost;

            // 각 스테이지 비용 계산
            for (int stage = 0; stage < n; stage++) {
                int usable = Math.min(hintCount[stage], n - 1);
                total += cost[stage][usable];
            }

            answer = Math.min(answer, total);
            return;
        }

        // 힌트를 구매하지 않는 경우
        dfs(idx + 1, currentCost, hintCount, cost, hint);

        // 힌트를 구매하는 경우
        int[] next = hintCount.clone();
        for (int i = 1; i < hint[idx].length; i++) {
            int stage = hint[idx][i] - 1;
            next[stage]++;
        }

        dfs(idx + 1, currentCost + hint[idx][0], next, cost, hint);
    }
}