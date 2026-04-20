class Solution {
    public int solution(String s) {
        int minLen = s.length();
        
        // 단위 1 ~ s.length()/2
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            String compressed = compress(s, unit);
            minLen = Math.min(minLen, compressed.length());
        }
        
        return minLen;
    }
    
    String compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        String prev = s.substring(0, unit);
        int count = 1;
        
        for (int i = unit; i < s.length(); i += unit) {
            int end = Math.min(i + unit, s.length());
            String cur = s.substring(i, end);
            
            if (cur.equals(prev) && cur.length() == unit) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                }
                result.append(prev);
                prev = cur;
                count = 1;
            }
        }
        
        // 마지막 처리
        if (count > 1) {
            result.append(count);
        }
        result.append(prev);
        
        return result.toString();
    }
}
