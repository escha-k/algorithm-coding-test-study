import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotCount = routes.length;
        
        List<int[]>[] robotPaths = new ArrayList[robotCount];
        int maxTime = 0;

        for (int i = 0; i < robotCount; i++) {
            robotPaths[i] = new ArrayList<>();
            int[] route = routes[i];
            int currentTime = 0;

            
            int[] startPos = points[route[0] - 1];
            int r = startPos[0];
            int c = startPos[1];
            robotPaths[i].add(new int[]{r, c});

            
            for (int j = 1; j < route.length; j++) {
                int[] nextPos = points[route[j] - 1];
                int nr = nextPos[0];
                int nc = nextPos[1];

                
                while (r != nr) {
                    r += (nr > r) ? 1 : -1;
                    robotPaths[i].add(new int[]{r, c});
                }
                
                while (c != nc) {
                    c += (nc > c) ? 1 : -1;
                    robotPaths[i].add(new int[]{r, c});
                }
            }
            maxTime = Math.max(maxTime, robotPaths[i].size());
        }

        
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < robotCount; i++) {
                
                if (t < robotPaths[i].size()) {
                    int[] pos = robotPaths[i].get(t);
                    String key = pos[0] + "," + pos[1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            
            for (int count : map.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }
}