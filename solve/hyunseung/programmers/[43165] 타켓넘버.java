class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    // idx: 현재 몇 번째 숫자를 보고 있는지
    // sum: idx 이전까지의 합
    private int dfs(int[] numbers, int target, int idx, int sum) {
        // 1. 모든 숫자를 다 쓴 경우
        if (idx == numbers.length) {
            // 타겟과 같으면 1가지 방법, 아니면 0
            return sum == target ? 1 : 0;
        }

        // 2. 아직 숫자가 남은 경우
        int plusCase  = dfs(numbers, target, idx + 1, sum + numbers[idx]);
        int minusCase = dfs(numbers, target, idx + 1, sum - numbers[idx]);

        return plusCase + minusCase;
    }
}