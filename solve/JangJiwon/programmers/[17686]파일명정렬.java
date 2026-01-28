import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] parts1 = split(f1);
            String[] parts2 = split(f2);
            
            int headCompare = parts1[0].toLowerCase()
                                .compareTo(parts2[0].toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }
            
            int num1 = Integer.parseInt(parts1[1]);
            int num2 = Integer.parseInt(parts2[1]);
            return num1 - num2;
        });
        
        return files;
    }
    
    // HEAD, NUMBER, TAIL 분리
    String[] split(String file) {
        int i = 0;
        
        // HEAD
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            i++;
        }
        String head = file.substring(0, i);
        
        // NUMBER
        int start = i;
        while (i < file.length() && Character.isDigit(file.charAt(i)) 
               && i - start < 5) {
            i++;
        }
        String number = file.substring(start, i);
        
        // TAIL
        return new String[]{head, number};
    }
}
