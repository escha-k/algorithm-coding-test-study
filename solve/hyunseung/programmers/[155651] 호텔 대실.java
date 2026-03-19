import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시간을 분 단위로 변환하고 정렬
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = parseTime(book_time[i][0]);
            times[i][1] = parseTime(book_time[i][1]) + 10; // 청소 시간 10분 추가
        }
        
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 2. 우선순위 큐로 종료 시간 관리 (가장 빨리 비는 방 순서)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            if (pq.isEmpty()) {
                pq.add(time[1]);
                continue;
            }

            // 가장 빨리 비는 방의 종료 시간이 현재 예약 시작 시간보다 작거나 같으면 재사용
            if (pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.add(time[1]);
        }

        return pq.size();
    }

    private int parseTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}