import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 1. 정렬 규칙에 따라 데이터 정렬
        // col-1 번째 컬럼 기준 오름차순, 동일 시 0번째 컬럼 기준 내림차순
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            }
            return a[col - 1] - b[col - 1];
        });
        
        // 2. row_begin부터 row_end까지 S_i 계산 및 XOR 연산
        // row_begin, row_end는 1-based 인덱스이므로 주의
        for (int i = row_begin; i <= row_end; i++) {
            int currentSi = 0;
            int[] row = data[i - 1]; // 실제 배열 인덱스는 i-1
            
            for (int val : row) {
                currentSi += (val % i);
            }
            
            // 3. XOR 연산 누적
            answer ^= currentSi;
        }
        
        return answer;
    }
}