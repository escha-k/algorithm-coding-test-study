import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long s1 = 0;
        long s2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            q1.offer(queue1[i]);
            s2 += queue2[i];
            q2.offer(queue2[i]);
        }

        // 두 큐의 합이 홀수일 경우 합을 같게 만들 수 없음
        if ((s1 + s2) % 2 != 0) {
            return -1;
        }

        int count = 0;
        int threshold = queue1.length * 3;
        while(s1 != s2) {
            if (count > threshold) {
                return -1;
            }

            // 합이 큰 쪽의 값을 추출하여 반대쪽 큐에 추가
            if (s1 > s2) {
                int n = q1.poll();
                s1 -= n;
                s2 += n;
                q2.offer(n);
            } else {
                int n = q2.poll();
                s2 -= n;
                s1 += n;
                q1.offer(n);
            }
            count++;
        }

        return count;
    }
}