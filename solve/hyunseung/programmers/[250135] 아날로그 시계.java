class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;


        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        
        if (start % 43200 == 0 || (start * 720) % 43200 == (start * 12) % 43200) {
            answer++;
        }

        
        for (int t = start; t < end; t++) {
            int curT = t % 43200;
            long s_start = (curT * 720) % 43200;
            long m_start = (curT * 12) % 43200;
            long h_start = (curT * 1) % 43200;

            long s_end = s_start + 720;
            long m_end = m_start + 12;
            long h_end = h_start + 1;

            boolean crossM = (s_start < m_start && s_end >= m_end);
            boolean crossH = (s_start < h_start && s_end >= h_end);

            if (crossM && crossH) {
                
                if ((m_start - s_start) * 719 == (h_start - s_start) * 708) {
                    answer += 1;
                } else {
                    answer += 2;
                }
            } else if (crossM || crossH) {
                answer += 1;
            }
        }

        return answer;
    }
}