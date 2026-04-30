class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = (int) getBlockNumber(begin + i);
        }

        return answer;
    }

    private long getBlockNumber(long n) {
        if (n == 1) return 0; 

        long maxDivisor = 1;
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                
                if (n / i <= 10000000) {
                    return n / i;
                }
                
                maxDivisor = i;
            }
        }
        
        return maxDivisor;
    }
}