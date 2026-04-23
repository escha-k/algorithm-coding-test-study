class Solution {
    int answer = 0;
    
    public int solution(int n) {
        int[] queens = new int[n];
        backtrack(0, n, queens);
        return answer;
    }
    
    void backtrack(int row, int n, int[] queens) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                backtrack(row + 1, n, queens);
            }
        }
    }
    
    boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            // 같은 열
            if (queens[i] == col) return false;
            // 대각선
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }
        return true;
    }
}
