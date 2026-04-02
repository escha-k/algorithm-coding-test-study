import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        
        // 1. 초기화: 숫자 리스트 생성 및 n! 계산
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        // 2. 0-based 인덱스로 맞추기 위해 k에서 1을 뺌
        k--;

        // 3. 각 자리에 들어갈 숫자를 순차적으로 결정
        for (int i = 0; i < n; i++) {
            // 이번 자리를 제외한 나머지 인원들로 만들 수 있는 순열의 수
            factorial /= (n - i);
            
            // k를 factorial로 나눈 몫이 현재 자리에 들어갈 숫자의 인덱스
            int index = (int) (k / factorial);
            answer[i] = list.get(index);
            
            // 사용한 숫자는 리스트에서 제거
            list.remove(index);
            
            // k를 나머지 값으로 갱신하여 다음 자리 계산 준비
            k %= factorial;
        }

        return answer;
    }
}