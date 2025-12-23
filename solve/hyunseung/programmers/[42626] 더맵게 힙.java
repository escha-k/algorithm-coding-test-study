import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add((long) s);

        int count = 0;

        // 이미 최소값이 K 이상이면 0
        while (!pq.isEmpty() && pq.peek() < K) {
            // 더 이상 섞을 재료가 없으면 불가능
            if (pq.size() < 2) return -1;

            long first = pq.poll();   // 가장 안 매운 것
            long second = pq.poll();  // 두 번째로 안 매운 것
            long mixed = first + (second * 2);

            pq.add(mixed);
            count++;
        }

        return count;
    }
}
