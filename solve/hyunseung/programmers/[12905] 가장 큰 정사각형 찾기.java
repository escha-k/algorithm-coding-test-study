class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        // 행이나 열이 1개뿐인 경우 예외 처리
        if (row < 2 || col < 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 1) return 1;
                }
            }
            return 0;
        }

        // DP 진행 (1,1)부터 시작
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    // 왼쪽, 위, 왼쪽 대각선 중 최솟값 + 1
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }
}