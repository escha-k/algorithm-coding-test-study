import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Set.of(phone_book);

        for (String s: phone_book) {
            for (int i = 1; i < s.length(); i++) {
                String sub = s.substring(0, i);
                if (set.contains(sub)) {
                    return false;
                }
            }
        }

        return true;
    }
}