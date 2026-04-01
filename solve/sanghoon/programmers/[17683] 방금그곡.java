import java.util.*;
import java.util.regex.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        List<String> pattern = parseMelody(m);

        for (String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");

            int start = parseTime(infos[0]);
            int end = parseTime(infos[1]);
            int playTime = end - start;

            String name = infos[2];

            List<String> base = parseMelody(infos[3]);
            List<String> totalMelody = totalMelody(base, playTime);

            if (containsMelody(totalMelody, pattern) && playTime > maxTime) {
                maxTime = playTime;
                answer = name;
            }
        }

        return answer;
    }

    private int parseTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);

        return hour * 60 + minute;
    }

    private List<String> parseMelody(String melody) {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("[A-G]#?");
        Matcher matcher = pattern.matcher(melody);

        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    private List<String> totalMelody(List<String> base, int playTime) {
        List<String> totalMelody = new ArrayList<>();
        int melodyLength = base.size();

        for (int i = 0; i < playTime; i++) {
            totalMelody.add(base.get(i % melodyLength));
        }

        return totalMelody;
    }

    private boolean containsMelody(List<String> target, List<String> pattern) {
        for (int i = 0; i <= target.size() - pattern.size(); i++) {
            boolean matched = true;
            for (int j = 0; j < pattern.size(); j++) {
                if (!target.get(i + j).equals(pattern.get(j))) {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                return true;
            }
        }

        return false;
    }
}