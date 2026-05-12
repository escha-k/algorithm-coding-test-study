import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int l = cards.length;
        boolean[] visited = new boolean[l];
        List<Integer> boxes = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            if (visited[i]) {
                continue;
            }

            int current = i;
            int size = 0;
            while(!visited[current]) {
                size++;
                visited[current] = true;
                current = cards[current] - 1;
            }

            boxes.add(size);
        }

        if (boxes.size() < 2) {
            return 0;
        } else {
            boxes.sort(Collections.reverseOrder());
            return boxes.get(0) * boxes.get(1);
        }
    }
}