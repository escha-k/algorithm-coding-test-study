import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            int ce = enemy[i];

            pq.offer(ce);
            n -= ce;

            if (n < 0) { // 이번 라운드 클리어에 필요한 병사가 부족한 경우
                if (k <= 0) { // 무적권이 없으면 클리어 실패
                    return i;
                }

                // 지난 라운드 중 가장 병사 소모가 많은 라운드에 무적권 사용 처리
                n += pq.poll();
                k--;
            }
        }

        return enemy.length;
    }
}