import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inParking = new HashMap<>();  // 차량번호 - 입차시간
        Map<String, Integer> totalTime = new TreeMap<>(); // 차량번호 - 누적시간

        for (String r : records) {
            String[] rs = r.split(" ");
            String timeStr = rs[0];

            if (rs[2].equals("IN")) { // 입차
                inParking.put(rs[1], timeStr);
            } else { // 출차
                String inTime = inParking.get(rs[1]);
                int diff = diff(inTime, timeStr);

                totalTime.merge(rs[1], diff, Integer::sum);
                inParking.remove(rs[1]);
            }
        }

        // 출차하지 않은 차량은 23:59에 일괄 출차
        for (Map.Entry<String, String> e : inParking.entrySet()) {
            String num = e.getKey();
            String inTime = e.getValue();
            int diff = diff(inTime, "23:59");

            totalTime.merge(num, diff, Integer::sum);
        }

        // 주차 요금 계산
        int[] answer = new int[totalTime.size()];
        int i = 0;
        for (String num : totalTime.keySet()) {
            int total = fees[1];

            int acc = totalTime.get(num);
            int exTime = acc - fees[0];

            if (exTime > 0) {
                total += (exTime / fees[2] + (exTime % fees[2] > 0 ? 1 : 0)) * fees[3];
            }

            answer[i++] = total;
        }

        return answer;
    }

    private int totalMin(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private int diff(String t1, String t2) {
        return Math.abs(totalMin(t1) - totalMin(t2));
    }
}