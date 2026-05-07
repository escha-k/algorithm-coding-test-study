import java.util.*;

class Solution {
    static Map<String, List<Integer>> allInfo;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        allInfo = new HashMap<>();

        
        for (String i : info) {
            String[] data = i.split(" ");
            makeSentence(data, "", 0);
        }

        
        for (String key : allInfo.keySet()) {
            Collections.sort(allInfo.get(key));
        }

        
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", "");
            String[] data = q.split(" ");
            int targetScore = Integer.parseInt(data[1]);

            answer[i] = binarySearch(data[0], targetScore);
        }

        return answer;
    }

    
    static void makeSentence(String[] data, String str, int cnt) {
        if (cnt == 4) {
            if (!allInfo.containsKey(str)) {
                allInfo.put(str, new ArrayList<>());
            }
            allInfo.get(str).add(Integer.parseInt(data[4]));
            return;
        }
        makeSentence(data, str + "-", cnt + 1);
        makeSentence(data, str + data[cnt], cnt + 1);
    }

    
    static int binarySearch(String key, int score) {
        if (!allInfo.containsKey(key)) return 0;
        List<Integer> scoreList = allInfo.get(key);
        
        int start = 0, end = scoreList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return scoreList.size() - start;
    }
}