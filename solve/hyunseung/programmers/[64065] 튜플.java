import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 바깥 {{ }} 제거
        String inner = s.substring(2, s.length() - 2); // 양 끝의 "{{" 와 "}}" 제거

        // 2. "},{" 기준으로 각 집합 분리
        String[] parts = inner.split("\\},\\{");

        // 3. 원소 개수(문자열 길이) 기준으로 오름차순 정렬
        Arrays.sort(parts, (a, b) -> a.length() - b.length());

        int n = parts.length;
        int[] answer = new int[n];
        int idx = 0;

        Set<Integer> seen = new HashSet<>();

        // 4. 작은 집합부터 보면서, 처음 등장하는 숫자만 순서대로 추가
        for (String part : parts) {
            String[] nums = part.split(",");

            for (String numStr : nums) {
                int value = Integer.parseInt(numStr);

                if (!seen.contains(value)) {
                    seen.add(value);
                    answer[idx++] = value;
                }
            }
        }

        return answer;
    }
}
