class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String s = convertTo(n, k);
        String[] ps = s.split("0");
        for (String p : ps) {
            if (isPrimeString(p)) {
                answer++;
            }
        }

        return answer;
    }

    // 10진수 -> k진수 변환
    // Integer.toString(n, k) 메서드 사용 가능
    String convertTo(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }

    // 소수 판별
    boolean isPrimeString(String s) {
        if (s.isBlank() || s.equals("1")) {
            return false;
        }

        long number = Long.parseLong(s);
        long sqrt = (long) Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}