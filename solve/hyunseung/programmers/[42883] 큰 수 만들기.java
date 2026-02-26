import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            // 스택이 비어있지 않고, 아직 지울 수 있는 횟수(k)가 남았으며,
            // 스택의 마지막 숫자가 현재 숫자보다 작으면 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k가 남은 경우 (예: "987", k=1) 뒤에서부터 남은 만큼 제외하고 생성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}