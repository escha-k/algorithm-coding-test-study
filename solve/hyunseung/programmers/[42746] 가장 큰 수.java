import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int 배열을 String 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 정렬 기준 재정의: (b + a)와 (a + b)를 비교
        // 예: "3"과 "30"이 있을 때, "330"과 "303" 중 더 큰 순서로 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 3. 모든 숫자가 0인 경우 처리 (예: [0, 0, 0] -> "000"이 아닌 "0" 반환)
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 4. 정렬된 숫자들을 하나로 합침
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        return answer.toString();
    }
}