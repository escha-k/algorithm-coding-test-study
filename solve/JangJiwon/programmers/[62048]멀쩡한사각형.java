class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        long gcd = gcd(W, H);
        
        return W * H - (W + H - gcd);
    }
    
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
