class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        // x 좌표를 0부터 d까지 k 간격으로 이동하며 반복
        for (long x = 0; x <= d; x += k) {
            // 피타고라스 정리를 이용해 x 좌표가 고정일 때 최대 y 좌표 계산
            // y^2 = d^2 - x^2
            long d2 = (long) d * d;
            long x2 = (long) x * x;
            int maxY = (int) Math.sqrt(d2 - x2);

            // 해당 x축 라인에서 찍을 수 있는 y 점의 개수 누적
            // k로 나눈 몫에 0 지점(+1)을 포함
            answer += (maxY / k) + 1;
        }

        return answer;
    }
}