import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        String[] tokens = expression.split("[+\\-*]");
        for (String t : tokens) {
            nums.add(Long.parseLong(t));
        }
        
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
            }
        }
        
        char[][] priorities = {
            {'+','-','*'}, {'+','*','-'}, {'-','+','*'},
            {'-','*','+'}, {'*','+','-'}, {'*','-','+'}
        };
        
        long max = 0;
        for (char[] p : priorities) {
            max = Math.max(max, Math.abs(calc(
                new ArrayList<>(nums), 
                new ArrayList<>(ops), 
                p)));
        }
        return max;
    }
    
    long calc(List<Long> nums, List<Character> ops, char[] p) {
        for (char op : p) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i) == op) {
                    long a = nums.get(i);
                    long b = nums.remove(i + 1);
                    nums.set(i, op == '+' ? a + b : op == '-' ? a - b : a * b);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }
}
