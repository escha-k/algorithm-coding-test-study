class Solution {
    public long solution(int n, long l, long r) {
        return count(n, l - 1, r - 1);  
    }
    
    long count(int n, long start, long end) {
        if (n == 0) {
            return 1;
        }
        
        if (start > end) {
            return 0;
        }
        
        long length = (long) Math.pow(5, n);
        long seg = length / 5;  // 각 구간 크기
        long total = 0;
        
        // 5등분
        for (int i = 0; i < 5; i++) {
            long segStart = i * seg;
            long segEnd = (i + 1) * seg - 1;
            
            // 구간 2(가운데)는 모두 0
            if (i == 2) continue;
            
            // 교집합 계산
            long setStart = Math.max(start, segStart);
            long setEnd = Math.min(end, segEnd);
            
            if (setStart <= setEnd) {
                total += count(n - 1, 
                              setStart - segStart, 
                              setEnd - segStart);
            }
        }
        
        return total;
    }
}
