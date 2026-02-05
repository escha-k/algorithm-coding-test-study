import java.util.HashSet;
import java.util.Iterator;

class Solution {
    // 중복된 숫자를 방지하기 위해 HashSet 사용
    HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // 1. 모든 숫자 조합을 만든다 (재귀 함수 호출)
        recursive("", numbers);

        // 2. 소수의 개수를 센다
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    // 모든 숫자 조합을 만드는 재귀 함수 (순열)
    public void recursive(String comb, String others) {
        // 현재 조합을 set에 추가 (빈 문자열 제외)
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        // 남은 숫자들 중에서 하나씩 더해가며 재귀 호출
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), 
                      others.substring(0, i) + others.substring(i + 1));
        }
    }

    // 소수 판별 함수
    public boolean isPrime(int num) {
        // 0과 1은 소수가 아님
        if (num == 0 || num == 1) {
            return false;
        }

        // 에라토스테네스의 체 원리를 이용해 루트 n까지만 확인
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}