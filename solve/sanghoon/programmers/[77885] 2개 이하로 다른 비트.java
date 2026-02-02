class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            int trailingOnes = Long.numberOfTrailingZeros(~n);
            int k = trailingOnes > 1 ? trailingOnes - 1 : 0;
            answer[i] = n + (1L << k);
        }

        return answer;
    }
}