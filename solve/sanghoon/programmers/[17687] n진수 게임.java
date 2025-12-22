class Solution {
    public String solution(int n, int t, int m, int p) {
        int currentNumber = 0;
        int turn = 0;
        StringBuilder answer = new StringBuilder();

        while (answer.length() < t) {
            String cs = Integer.toString(currentNumber, n);

            for (int i = 0; i < cs.length(); i++) {
                turn++;
                if (turn == p && answer.length() < t) {
                    answer.append(cs.charAt(i));
                }
                turn %= m;
            }

            currentNumber++;
        }

        return answer.toString().toUpperCase(); // A~F를 대문자로 반환
    }
}