import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> Integer.compare(o1[1], o2[1])); // 끝 시간 기준 정렬

        int answer = 0;
        int last = -1;
        for (int[] t : targets) {
            if (t[0] >= last) {
                answer++;
                last = t[1];
            }
        }

        return answer;
    }
}