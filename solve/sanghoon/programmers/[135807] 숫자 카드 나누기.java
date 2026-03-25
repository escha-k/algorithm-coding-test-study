class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getArrayGCD(arrayA);
        int gcdB = getArrayGCD(arrayB);

        int maxA = (gcdA > 1 && canBeAnswer(gcdA, arrayB)) ? gcdA : 0;
        int maxB = (gcdB > 1 && canBeAnswer(gcdB, arrayA)) ? gcdB : 0;

        return Math.max(maxA, maxB);
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int getArrayGCD(int[] array) {
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = getGCD(gcd, array[i]);
            if (gcd == 1) {
                return 1;
            }
        }
        return gcd;
    }

    // 주어진 숫자로 배열의 값을 전부 나눌 수 없다면 true 반환
    // 하나라도 나눌 수 있다면 false 반환
    private boolean canBeAnswer(int gcd, int[] array) {
        for (int x : array) {
            if (x % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}