
class Solution {
    public int[] solution(int[][] edges) {
     
        int[] in = new int[1000001];
        int[] out = new int[1000001];
        int maxNode = 0;

        for (int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        int createdNode = 0;
        int donutCount = 0;
        int stickCount = 0;
        int eightCount = 0;

        for (int i = 1; i <= maxNode; i++) {
           
            if (in[i] == 0 && out[i] >= 2) {
                createdNode = i;
            } 
           
            else if (out[i] == 0) {
                stickCount++;
            } 
            
            else if (out[i] == 2) {
                eightCount++;
            }
        }

        
        int totalGraphs = out[createdNode];
        donutCount = totalGraphs - stickCount - eightCount;

        return new int[]{createdNode, donutCount, stickCount, eightCount};
    }
}