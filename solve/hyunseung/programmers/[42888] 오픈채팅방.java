import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 1. 유저 아이디별 최신 닉네임을 저장할 맵
        Map<String, String> nicknameMap = new HashMap<>();
        // 2. 출력할 메시지 정보를 담을 리스트 (유저아이디, 행동)
        List<String[]> log = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0]; // Enter, Leave, Change
            String userId = parts[1];

            if (action.equals("Enter")) {
                String nickname = parts[2];
                nicknameMap.put(userId, nickname); // 닉네임 업데이트 또는 삽입
                log.add(new String[]{userId, "님이 들어왔습니다."});
            } else if (action.equals("Leave")) {
                log.add(new String[]{userId, "님이 나갔습니다."});
            } else if (action.equals("Change")) {
                String nickname = parts[2];
                nicknameMap.put(userId, nickname); // 닉네임 변경
            }
        }

        // 3. 로그 리스트를 순회하며 최종 닉네임으로 메시지 조립
        String[] answer = new String[log.size()];
        for (int i = 0; i < log.size(); i++) {
            String userId = log.get(i)[0];
            String message = log.get(i)[1];
            answer[i] = nicknameMap.get(userId) + message;
        }

        return answer;
    }
}