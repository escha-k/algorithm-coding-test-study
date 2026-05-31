class Solution {
    int maxLeaves = 1;
    
    public int solution(int dist_limit, long split_limit) {
        dfs(1, 0, 1, dist_limit, split_limit);
        return maxLeaves;
    }
    
    void dfs(long nodes, int distUsed, long product, 
             int distLimit, long splitLimit) {
        // 현재까지의 리프 노드 수 갱신
        maxLeaves = Math.max(maxLeaves, (int) Math.min(nodes, Integer.MAX_VALUE));

        // 종료 
        if (distUsed >= distLimit) return;
        
        // 남은 분배 노드로 확장 가능한 최대치 계산
        long canExpand = Math.min(nodes, distLimit - distUsed);
        
        if (canExpand < nodes) {
            // 일부만 확장 (마지막 레벨)
            long remain = nodes - canExpand;
            
            if (product * 2 <= splitLimit) {
                maxLeaves = Math.max(maxLeaves, 
                    (int) Math.min(remain + canExpand * 2, Integer.MAX_VALUE));
            }
            if (product * 3 <= splitLimit) {
                maxLeaves = Math.max(maxLeaves, 
                    (int) Math.min(remain + canExpand * 3, Integer.MAX_VALUE));
            }
            return;
        }
        
        // 모두 확장
        if (product * 2 <= splitLimit) {
            dfs(nodes * 2, distUsed + (int)nodes, product * 2, 
                distLimit, splitLimit);
        }
        
        if (product * 3 <= splitLimit) {
            dfs(nodes * 3, distUsed + (int)nodes, product * 3, 
                distLimit, splitLimit);
        }
    }
}
