import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 대소문자 미구분 -> 대문자로 일괄 처리
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 각 문자열별 다중집합 생성 - 문자열:등장횟수
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                String key = str1.substring(i, i + 2);
                map1.merge(key, 1, Integer::sum);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                String key = str2.substring(i, i + 2);
                map2.merge(key, 1, Integer::sum);
            }
        }

        // 양쪽 모두 비어있는 경우 유사도는 1
        if (map1.isEmpty() && map2.isEmpty()) {
            return 1 * 65536;
        }

        // 한쪽만 비어있는 경우 유사도는 0
        if (map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }

        // 유사도 계산을 위한 전체 키 집합 생성
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        // 자카드 유사도 계산
        int intersection = 0;
        int union = 0;

        for (String key : keys) {
            int v1 = map1.getOrDefault(key, 0);
            int v2 = map2.getOrDefault(key, 0);

            intersection += Math.min(v1, v2);
            union += Math.max(v1, v2);
        }

        double jaccard = (double) intersection / union;

        return (int) (jaccard * 65536);
    }
}