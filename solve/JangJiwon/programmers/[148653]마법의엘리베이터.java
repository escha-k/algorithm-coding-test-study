class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            // 일의 자리 확인
            int digit = storey % 10;
            // 다음 자리 확인
            storey /= 10;
            
            // 일의 자리가 5보다 클 경우 올라가는 게 유리
            if (digit > 5) {
                answer += 10 - digit;   
                storey++;
            }
            // 일의 자리가 5보다 작을 경우 내려가는 게 유리
            else if (digit < 5) {
                answer += digit;
            } 
            // 일의 자리가 5인 경우
            else {
                // 다음 자리가 5이상이면
                if (storey % 10 >= 5) {
                    answer += 5;
                    storey++;
                } else {
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}
