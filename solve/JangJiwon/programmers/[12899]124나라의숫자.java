class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            
            if (remainder == 0) {
                answer.insert(0, "4");
                n--;
            } else if (remainder == 1) {
                answer.insert(0, "1");
            } else {
                answer.insert(0, "2");
            }
        }
        
        return answer.toString();
    }
}
