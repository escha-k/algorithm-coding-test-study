
class Solution {
    int totalCount = 0;

    public int solution(int n, int[][] q, int[] ans) {
        // 5개의 숫자를 뽑는 조합 탐색 시작
        generateCombinations(new int[5], 1, 0, n, q, ans);
        return totalCount;
    }

    private void generateCombinations(int[] current, int start, int depth, int n, int[][] q, int[] ans) {
        // 5개를 모두 뽑았을 때
        if (depth == 5) {
            // 해당 조합이 모든 시도 결과와 일치하는지 확인
            if (isValid(current, q, ans)) {
                totalCount++;
            }
            return;
        }

        // 오름차순으로 숫자를 선택하여 조합 생성
        for (int i = start; i <= n; i++) {
            current[depth] = i;
            generateCombinations(current, i + 1, depth + 1, n, q, ans);
        }
    }

    private boolean isValid(int[] candidate, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;
            // 후보 조합과 시도된 숫자 q[i] 간의 겹치는 개수 계산
            for (int candNum : candidate) {
                for (int queryNum : q[i]) {
                    if (candNum == queryNum) {
                        matchCount++;
                        break;
                    }
                }
            }
            // 겹치는 개수가 실제 응답(ans[i])과 다르면 오답
            if (matchCount != ans[i]) {
                return false;
            }
        }
        return true;
    }
}