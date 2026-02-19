class Solution {
    public int[] solution(int[][] arr) {
        return check(arr, 0, 0, arr.length);
    }
    
    int[] check(int[][] arr, int x, int y, int size) {
        // 모두 같은 값일 경우
        if (isSame(arr, x, y, size)) {
            if (arr[x][y] == 0) {
                return new int[]{1, 0};  // 다 0
            } else {
                return new int[]{0, 1};  // 다 1
            }
        }
        
        // 다를 경우 
        int half = size / 2;
        int[] one = check(arr, x, y, half);
        int[] two = check(arr, x, y + half, half);
        int[] three = check(arr, x + half, y, half);
        int[] four = check(arr, x + half, y + half, half);
        
        return new int[]{
            one[0] + two[0] + three[0] + four[0],
            one[1] + two[1] + three[1] + four[1]
        };
    }

  // 같은 값인지 확인
    boolean isSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }
}
