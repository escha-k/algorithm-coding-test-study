import java.util.Arrays;

class Solution {
    static int[] discountPercent = {10, 20, 30, 40};
    static int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {

        dfs(emoticons, 0, new int[emoticons.length], users);

        return answer;
    }

    void dfs(int[] emoticons, int depth, int[] discounts, int[][] users) {
        if (depth == emoticons.length) {
            calculate(emoticons, discounts, users);
            return;
        }

        for (int i = 0; i < discountPercent.length; i++) {
            discounts[depth] = discountPercent[i];
            dfs(emoticons, depth + 1, discounts, users);
        }
    }

    void calculate(int[] emoticons, int[] discounts, int[][] users) {
        int plus = 0;
        int total = 0;

        for (int[] user : users) {
            int sum = 0;
            int rateBound = user[0];
            int sumBound = user[1];

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= rateBound) {
                    sum += emoticons[i] / 100 * (100 - discounts[i]);
                }
            }

            if (sum >= sumBound) {
                plus++;
            } else {
                total += sum;
            }
        }

        if (plus > answer[0] || (plus == answer[0] && total > answer[1])) {
            answer[0] = plus;
            answer[1] = total;
        }
    }
}