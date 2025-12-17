import java.util.*;

class Solution {
    static String[] alphabet = {"A","E","I","O","U"};
    static int answer = 0;
    
    public int solution(String word) {
        answer = 0;
        dfs("",word);
        return answer;
    }
    
    boolean dfs(String current, String target){
        if(current.equals(target)){
            return true;
        }
        if(current.length()==5){
            return false;
        }
        for(String a : alphabet){
            answer++;
            if(dfs(current + a, target)){
                return true;
            }
        }
        return false;
    }
}
