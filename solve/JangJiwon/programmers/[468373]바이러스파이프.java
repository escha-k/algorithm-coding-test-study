import java.util.*;

class Solution {
    Map<Integer, List<int[]>> graph;
    int maxInfected;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        // 그래프 구성
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        maxInfected = 1;
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        
        backtrack(infected, k);
        
        return maxInfected;
    }

    // 백트래킹
    void backtrack(boolean[] infected, int remain) {
        int count = countInfected(infected);
        maxInfected = Math.max(maxInfected, count);
        
        if (remain == 0) return;
        
        // 3가지 타입 시도
        for (int type = 1; type <= 3; type++) {
            boolean[] newInfected = infected.clone();
            spread(newInfected, type);
            backtrack(newInfected, remain - 1);
        }
    }

    // BFS 전파
    void spread(boolean[] infected, int type) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 현재 감염된 노드들
        for (int i = 1; i < infected.length; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int edgeType = next[1];
                
                if (!infected[nextNode] && edgeType == type) {
                    infected[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
    }

    // 감염된 배양체 개수
    int countInfected(boolean[] infected) {
        int count = 0;
        for (boolean b : infected) {
            if (b) count++;
        }
        return count;
    }
}
