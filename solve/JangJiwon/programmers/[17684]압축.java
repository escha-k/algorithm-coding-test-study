import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // 사전 초기화
        Map<String, Integer> dict = new HashMap<>();
        for(int i=0;i<26;i++){
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        int nextNum = 27;
        
        int idx = 0;
        
        // 현재 위치에서 사전에 있는 가장 긴 문자열 w찾기
        while(idx<msg.length()){
            String w = "";;
            int j = idx;
            
            while(j<msg.length()){
                String temp = msg.substring(idx, j+1);
                if(dict.containsKey(temp)){
                    w = temp;
                    j++;
                } else {
                    break;
                }
            }
            
            // w의 색인 번호를 결과에 추가
            answer.add(dict.get(w));
            
            // 다음 글자 c가 있으면 w+c를 사전에 등록
            if(j<msg.length()){
                String wc = w + msg.charAt(j);
                dict.put(wc, nextNum++);
            }
            
            // w만큼 진행
            idx += w.length();
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
