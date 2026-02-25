import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        int sum = 0;
        int time = 0;
        int idx = 0;
        while (!queue.isEmpty()) {
            sum -= queue.poll();
            time++;

            if (idx >= truck_weights.length) {
                continue;
            }

            // 새로운 트럭을 추가할 수 있다면 해당 트럭을 삽입
            // 추가할 수 없다면 0을 삽입
            int next = truck_weights[idx];
            if (sum + next <= weight) {
                queue.offer(next);
                sum += next;
                idx++;
            } else {
                queue.offer(0);
            }
        }

        return time;
    }
}