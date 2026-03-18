import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // index 1 ~ n 활용
            graph.add(new ArrayList<>());
        }

        for (int[] v : wires) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }

        // 간선을 하나씩 끊어보면서 BFS로 송전탑의 수 계산
        int answer = Integer.MAX_VALUE;
        for (int[] v : wires) {
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            queue.offer(v[0]);
            visited[v[0]] = true;
            visited[v[1]] = true; // 트리 구조이므로 미리 방문 처리하면 간선을 끊을 수 있음

            int count = 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph.get(current)) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }

            int diff = Math.abs(n - count * 2); // 한쪽은 count, 반대쪽은 (n - count)
            answer = Math.min(answer, diff);
        }

        return answer;
    }
}