import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 각 기능별로 배포에 필요한 기간을 계산하여 순서대로 큐에 저장
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            int speed = speeds[i];
            int days = left % speed == 0 ? left / speed : left / speed + 1;

            queue.offer(days);
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            // 큐 맨앞의 기능을 배포 시작
            int currentDay = queue.poll();

            // 함께 배포 가능한 기능 수를 계산: 이미 완성된 작업들은 배포를 위해 큐에서 제거
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}