import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights); // 오름차순 정렬
        Map<Double, Integer> map = new HashMap<>();
        
        for (int w : weights) {
            double a = w * 1.0;
            double b = (w * 2.0) / 3.0;
            double c = (w * 1.0) / 2.0;
            double d = (w * 3.0) / 4.0;
            
            // 현재 몸무게와 짝꿍이 될 수 있는 비율들이 이전에 있었는지 확인
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);
            
            // 현재 몸무게 빈도수 업데이트
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return answer;
    }
}