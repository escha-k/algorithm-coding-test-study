import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 1. 내림차순 정렬을 위해 일단 오름차순 정렬
        Arrays.sort(citations); // 오름차순

        int n = citations.length;
        int h = 0;

        // 2. 뒤에서부터 보면서 (내림차순처럼 사용)
        // i: 배열 인덱스, n - i: 현재 논문 이상 인용된 논문 개수
        for (int i = 0; i < n; i++) {
            int cited = citations[i]; // 현재 논문의 인용수
            int papers = n - i; // 이 논문 이상 인용된 논문 개수

            if (cited >= papers) {
                h = papers;
                break;
            }
        }

        return h;
    }
}
