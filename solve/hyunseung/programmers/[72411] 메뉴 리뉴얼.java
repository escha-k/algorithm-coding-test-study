import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int c : course) {
            map = new HashMap<>();
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr); // 정렬해서 조합 생성 (ABC와 CBA 방지)
                combination(arr, 0, c, "");
            }

            // 가장 많이 주문된 횟수 찾기
            if (!map.isEmpty()) {
                List<Integer> counts = new ArrayList<>(map.values());
                int max = Collections.max(counts);

                if (max >= 2) { // 최소 2명 이상 주문한 경우만
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 조합 구하기 (DFS)
    public void combination(char[] arr, int start, int r, String res) {
        if (res.length() == r) {
            map.put(res, map.getOrDefault(res, 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combination(arr, i + 1, r, res + arr[i]);
        }
    }
}