class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }

            // 현재 수열의 길이가 기존보다 짧을 경우에만 갱신
            if (sum == k && (right - left) < length) {
                length = right - left;
                answer[0] = left;
                answer[1] = right;
            }
        }

        return answer;
    }
}