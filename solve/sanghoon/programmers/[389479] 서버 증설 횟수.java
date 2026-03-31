import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int time = 0;
        Queue<Integer> server = new ArrayDeque<>(); // 서버 반납 시간을 저장

        for (int player : players) {
            // 운영 시간이 지난 서버 반납
            while (!server.isEmpty() && server.peek() <= time) {
                server.poll();
            }

            // 필요한 서버 수 계산 후 부족한 서버 추가
            int additionalServer = player / m;
            while (server.size() < additionalServer) {
                server.offer(time + k);
                answer++;
            }

            time++;
        }

        return answer;
    }
}