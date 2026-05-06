class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 현재 트럭에서 처리 가능한 배달/수거 용량
        int deliver = 0;
        int pickup = 0;

        for (int i = n - 1; i >= 0; i--) { // 가장 먼 집부터 차례대로 처리
            // 현재 집에서 처리해야 할 배달/수거량 처리
            deliver -= deliveries[i];
            pickup -= pickups[i];

            // 현재 집에서 배달이나 수거 용량이 부족한 경우 물류창고 추가 왕복 필요
            int count = 0;
            while (deliver < 0 || pickup < 0) {
                deliver += cap;
                pickup += cap;
                count++;
            }

            // 이동 거리 계산: 거리 * 2(왕복) * 물류창고 왕복 횟수
            answer += (long) (i + 1) * 2 * count;
        }

        return answer;
    }
}