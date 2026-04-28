import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> time(a[1]) - time(b[1]));
        
        List<String> answer = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();  // [시작시간, 남은시간]
        
        for (int i = 0; i < plans.length; i++) {
            int start = time(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);
            
            if (i < plans.length - 1) {
                int gap = time(plans[i + 1][1]) - start;
                
                if (play <= gap) {
                    answer.add(plans[i][0]);
                    gap -= play;
                    
                    while (!stack.isEmpty() && gap > 0) {
                        int[] task = stack.pop();
                        if (task[1] <= gap) {
                            answer.add(plans[task[0]][0]);
                            gap -= task[1];
                        } else {
                            stack.push(new int[]{task[0], task[1] - gap});
                            break;
                        }
                    }
                } else {
                    stack.push(new int[]{i, play - gap});
                }
            } else {
                answer.add(plans[i][0]);
            }
        }
        
        while (!stack.isEmpty()) {
            answer.add(plans[stack.pop()[0]][0]);
        }
        
        return answer.toArray(new String[0]);
    }
    
    int time(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
