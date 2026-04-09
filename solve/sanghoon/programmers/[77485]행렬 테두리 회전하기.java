class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i * columns + j + 1;
            }
        }

        int l = queries.length;
        int[] answer = new int[l];
        for (int i = 0; i < l; i++) {
            int[] query = queries[i];
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp = arr[x1][y1]; // 시작점 값 보관
            int min = temp;

            // 왼쪽 세로줄 (아래에서 위로 이동)
            for (int r = x1; r < x2; r++) {
                arr[r][y1] = arr[r + 1][y1];
                min = Math.min(min, arr[r][y1]);
            }

            // 아래쪽 가로줄 (오른쪽에서 왼쪽으로 이동)
            for (int c = y1; c < y2; c++) {
                arr[x2][c] = arr[x2][c + 1];
                min = Math.min(min, arr[x2][c]);
            }

            // 오른쪽 세로줄 (위에서 아래로 이동)
            for (int r = x2; r > x1; r--) {
                arr[r][y2] = arr[r - 1][y2];
                min = Math.min(min, arr[r][y2]);
            }

            // 위쪽 가로줄 (왼쪽에서 오른쪽으로 이동)
            for (int c = y2; c > y1 + 1; c--) {
                arr[x1][c] = arr[x1][c - 1];
                min = Math.min(min, arr[x1][c]);
            }

            arr[x1][y1 + 1] = temp; // 시작점의 값 넣기

            answer[i] = min;
        }

        return answer;
    }
}