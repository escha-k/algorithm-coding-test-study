class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // diffs[i]의 최솟값
        int right = 100_000; // diffs[i]의 최댓값
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solvePuzzle(diffs, times, mid) <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private long solvePuzzle(int[] diffs, int[] times, int level) {
        long total = 0;

        int n = diffs.length;
        for (int i = 0; i < n; i++) {
            int diff = diffs[i];
            int curTime = times[i];
            int prevTime = i > 0 ? times[i - 1] : 0;

            if (diff <= level) {
                total += curTime;
            } else {
                total += (long) (curTime + prevTime) * (diff - level) + curTime;
            }
        }

        return total;
    }
}