class Solution {
    public int solution(String[] board) {
        int o = 0;
        int x = 0;

        for (String b : board) {
            for (int i = 0; i < 3; i++) {
                if (b.charAt(i) == 'O') {
                    o++;
                } else if (b.charAt(i) == 'X') {
                    x++;
                }
            }
        }

        int diff = o - x;
        if (diff < 0 || diff > 1) {
            return 0;
        }

        boolean oWin = isThreeMatched(board, 'O');
        boolean xWin = isThreeMatched(board, 'X');

        if (oWin && xWin) {
            return 0;
        } else if (oWin && !xWin && diff != 1) {
            return 0;
        } else if (!oWin && xWin && diff != 0) {
            return 0;
        }

        return 1;
    }

    private boolean isThreeMatched(String[] board, char c) {
        // 가로, 세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)  {
                return true;
            }
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }

        // 대각선 검사
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }

        return false;
    }
}