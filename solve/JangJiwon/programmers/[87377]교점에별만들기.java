import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        
        // 정수 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long[] point = getIntersection(line[i], line[j]);
                if (point != null) {
                    points.add(point);
                }
            }
        }
        
        // 좌표
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        
        for (long[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }
        
        // 격자 생성
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] grid = new char[height][width];
        
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }
        
        // 별 찍기
        for (long[] p : points) {
            int x = (int)(p[0] - minX);
            int y = (int)(maxY - p[1]);
            grid[y][x] = '*';
        }
        
        // 문자열 변환
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }

  
    long[] getIntersection(int[] l1, int[] l2) {
        long A = l1[0], B = l1[1], E = l1[2];
        long C = l2[0], D = l2[1], F = l2[2];
        
        long det = A * D - B * C;

        // 평행 혹은 일치할 경우
        if (det == 0) return null;
        
        long x = B * F - E * D;
        long y = E * C - A * F;

        // 정수 좌표 확인
        if (x % det != 0 || y % det != 0) return null;
        
        return new long[]{x / det, y / det};
    }
}
