import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] wetTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(wetTime[i], drops.length);
        }
        
        for (int i = 0; i < drops.length; i++) {
            wetTime[drops[i][0]][drops[i][1]] = i;
        }
        
        // 2D 슬라이딩 윈도우로 최솟값 계산
        int[][] minArea = new int[m - h + 1][n - w + 1];
        
        // 가로 방향 슬라이딩 윈도우
        int[][] rowMin = new int[m][n - w + 1];
        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int c = 0; c < n; c++) {
                // 범위 벗어난 인덱스 제거
                while (!dq.isEmpty() && dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }
                
                // 현재 값보다 큰 값들 제거
                while (!dq.isEmpty() && wetTime[r][dq.peekLast()] >= wetTime[r][c]) {
                    dq.pollLast();
                }
                
                dq.offerLast(c);
                
                // 윈도우가 완성되면 최솟값 저장
                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = wetTime[r][dq.peekFirst()];
                }
            }
        }
        
        // 세로 방향 슬라이딩 윈도우
        for (int c = 0; c < n - w + 1; c++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }
                
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }
                
                dq.offerLast(r);
                
                if (r >= h - 1) {
                    minArea[r - h + 1][c] = rowMin[dq.peekFirst()][c];
                }
            }
        }
        
        // 최대값 찾기
        int maxTime = -1;
        int[] answer = new int[2];
        
        for (int r = 0; r < m - h + 1; r++) {
            for (int c = 0; c < n - w + 1; c++) {
                if (minArea[r][c] > maxTime) {
                    maxTime = minArea[r][c];
                    answer[0] = r;
                    answer[1] = c;
                }
            }
        }
        
        return answer;
    }
}
