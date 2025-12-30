import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s:skill_trees){
            StringBuilder sb = new StringBuilder();
            
            for(char c:s.toCharArray()){
                if(skill.indexOf(c) != -1){
                    sb.append(c);
                }
            }
            
            if(isPrefix(skill, sb.toString())){
                answer++;
            }
        }
        return answer;
    }
    
    boolean isPrefix(String str, String prefix){
        if(prefix.length() > str.length())
            return false;
        
        for(int i=0;i<prefix.length();i++){
            if(str.charAt(i)!=prefix.charAt(i))
                return false;
        }
        
        return true;
    }
}
