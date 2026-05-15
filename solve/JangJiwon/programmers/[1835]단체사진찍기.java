class Solution {
    int answer = 0;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        line(new boolean[8], new char[8], 0, data);
        return answer;
    }
    
    // 줄 세우기
    void line(boolean[] visited, char[] arr, int depth, String[] data) {
        if (depth == 8) {
            if (check(arr, data)) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = friends[i];
                line(visited, arr, depth + 1, data);
                visited[i] = false;
            }
        }
    }

    // 위치 확인
    boolean check(char[] arr, String[] data) {
        for (String condition : data) {
            char f1 = condition.charAt(0);
            char f2 = condition.charAt(2);
            char op = condition.charAt(3);
            int target = condition.charAt(4) - '0';
            
            // 위치 찾기
            int pos1 = -1, pos2 = -1;
            for (int i = 0; i < 8; i++) {
                if (arr[i] == f1) pos1 = i;
                if (arr[i] == f2) pos2 = i;
            }
            
            // 간격
            int dist = Math.abs(pos1 - pos2) - 1;
            
            // 조건 확인
            if (op == '=') {
                if (dist != target) return false;
            } else if (op == '<') {
                if (dist >= target) return false;
            } else if (op == '>') {
                if (dist <= target) return false;
            }
        }
        return true;
    }
}
