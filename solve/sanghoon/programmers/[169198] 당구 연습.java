class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            int bX = ball[0];
            int bY = ball[1];
            int min = Integer.MAX_VALUE;

            // 대칭을 통해 이동거리 계산
            // 위 -> 아래 -> 왼쪽 -> 오른쪽
            if (!(startX == bX && startY < bY)) {
                int rY = n + (n - bY);
                min = Math.min(min, dist(startX, startY, bX, rY));
            }

            if (!(startX == bX && startY > bY)) {
                int rY = - bY;
                min = Math.min(min, dist(startX, startY, bX, rY));
            }

            if (!(startY == bY && startX > bX)) {
                int rX = -bX;
                min = Math.min(min, dist(startX, startY, rX, bY));
            }

            if (!(startY == bY && startX < bX)) {
                int rX = m + (m - bX);
                min = Math.min(min, dist(startX, startY, rX, bY));
            }

            answer[i] = min;
        }

        return answer;
    }

    private int dist(int sx, int sy, int ex, int ey) {
        return (ex - sx) * (ex - sx) + (ey - sy) * (ey - sy);
    }
}