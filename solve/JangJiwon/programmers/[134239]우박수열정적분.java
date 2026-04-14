import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 수열 생성
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while (k != 1) {
            k = (k % 2 == 0) ? k / 2 : k * 3 + 1;
            list.add(k);
        }
        
        int n = list.size() - 1;  
        
        // 각 구간 면적 계산 
        double[] area = new double[n];
        for (int i = 0; i < n; i++) {
            area[i] = (list.get(i) + list.get(i + 1)) / 2.0;
        }
        
        // 누적 합
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + area[i];
        }
        
        // 쿼리 처리
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            // b가 음수거나 a > b이면 유효하지 않음
            if (b < 0 || a > b) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[b] - prefix[a];
            }
        }
        
        return answer;
    }
}
