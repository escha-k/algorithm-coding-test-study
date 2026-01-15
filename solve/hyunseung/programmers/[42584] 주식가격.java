import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 스택

        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택 top 시점의 가격보다 낮아지는 순간 => 그 시점 정답 확정
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 애들 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (n - 1) - idx;
        }

        return answer;
    }
}
