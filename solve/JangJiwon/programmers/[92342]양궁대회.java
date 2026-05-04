class Solution {
    int maxDiff = 0;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[11]);
        return answer;
    }
    
    void dfs(int idx, int remain, int[] apeach, int[] ryan) {
        if (idx == 11) {
            if (remain > 0) {
                ryan[10] = remain;  // 남은 화살 0점에
            }
            
            int diff = calcDiff(apeach, ryan);
            
            if (diff > 0 && diff >= maxDiff) {
                if (diff > maxDiff || isLower(ryan, answer)) {
                    maxDiff = diff;
                    answer = ryan.clone();
                }
            }
            
            ryan[10] = 0;
            return;
        }
        
        // 해당 점수 획득
        if (remain > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(idx + 1, remain - ryan[idx], apeach, ryan);
            ryan[idx] = 0;
        }
        
        // 포기
        dfs(idx + 1, remain, apeach, ryan);
    }
    
    int calcDiff(int[] apeach, int[] ryan) {
        int aScore = 0, rScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            
            if (ryan[i] > apeach[i]) {
                rScore += 10 - i;
            } else {
                aScore += 10 - i;
            }
        }
        
        return rScore - aScore;
    }
    
    boolean isLower(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) {
                return a[i] > b[i];
            }
        }
        return false;
    }
}
