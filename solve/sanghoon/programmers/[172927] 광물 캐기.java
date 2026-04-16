import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 캘 수 있는 최대 그룹 수 계산
        // 총 곡괭이의 수와 mineral을 5개씩 묶은 그룹의 수 중 작은 값
        int size = Math.min(picks[0] + picks[1] + picks[2], (minerals.length + 4) / 5);

        // 광물을 5개씩 순서대로 묶어서 그릅화 -> 정렬
        PriorityQueue<Group> groups = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            Group g = new Group();

            int l = Math.min((i + 1) * 5, minerals.length);
            for (int j = i * 5; j < l; j++) {
                switch (minerals[j]) {
                    case "diamond" -> g.diamond++;
                    case "iron" -> g.iron++;
                    case "stone" -> g.stone++;
                }
            }

            groups.offer(g);
        }

        // 그리디 알고리즘
        int answer = 0;
        for (Group g : groups) {
            int diamond = g.diamond;
            int iron = g.iron;
            int stone = g.stone;

            if (picks[0] > 0) {
                answer += diamond + iron + stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += diamond * 5 + iron + stone;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += diamond * 25 + iron * 5 + stone;
                picks[2]--;
            }
        }

        return answer;
    }

    static class Group implements Comparable<Group> {
        int diamond;
        int iron;
        int stone;

        @Override
        public int compareTo(Group o) { // 다이아가 많은 순 -> 철이 많은 순으로 정렬
            if (this.diamond != o.diamond) {
                return Integer.compare(o.diamond, this.diamond);
            }

            return Integer.compare(o.iron, this.iron);
        }
    }
}