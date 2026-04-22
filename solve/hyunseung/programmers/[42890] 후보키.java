import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        // 1. 모든 컬럼 조합을 비트마스크로 탐색 (1부터 2^colLen - 1까지)
        for (int i = 1; i < (1 << colLen); i++) {
            // 2. 최소성 검사
            if (!isMinimal(i, candidateKeys)) continue;

            // 3. 유일성 검사
            if (isUnique(i, relation, rowLen, colLen)) {
                candidateKeys.add(i);
            }
        }

        return candidateKeys.size();
    }

    private boolean isUnique(int mask, String[][] relation, int rowLen, int colLen) {
        Set<String> set = new HashSet<>();

        for (int r = 0; r < rowLen; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < colLen; c++) {
                // mask의 c번째 비트가 1인지 확인
                if ((mask & (1 << c)) != 0) {
                    sb.append(relation[r][c]).append("/"); // 구분자 추가
                }
            }
            set.add(sb.toString());
        }

        return set.size() == rowLen;
    }

    private boolean isMinimal(int mask, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            // 이미 저장된 후보키(key)가 현재 조합(mask)에 완전히 포함되는지 확인
            if ((key & mask) == key) {
                return false;
            }
        }
        return true;
    }
}