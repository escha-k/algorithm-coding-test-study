class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        
        // 각 문자 생성
        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int move = n - 1;  // 오른쪽으로만 가는 경우
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            // 연속된 A 건너뛰기
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // i까지 가고 되돌아가기
            move = Math.min(move, i + i + n - next);
            
            // 반대편 먼저 가고 되돌아오기
            move = Math.min(move, (n - next) + (n - next) + i);
        }
        
        return answer + move;
    }
}
