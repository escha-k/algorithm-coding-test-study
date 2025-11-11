class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            long pos = left + i;

            // 1차원 배열의 pos 위치는 nxn 배열의 (x,y) 위치에 해당
            int x = (int) (pos / n);
            int y = (int) (pos % n);

            // nxn 배열에서 (x, y)의 값은 x와 y중 더 큰 값 + 1
            answer[i] = Math.max(x, y) + 1;
        }

        return answer;
    }
}