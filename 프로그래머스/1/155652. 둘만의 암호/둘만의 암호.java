class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            int idx = 0;
            char c;
            while (idx < index) {
                int a = (int) s.charAt(i) + j + idx;
                if (a > 'z') {
                    a = (a - 'a') % 26 + 'a';
                }
                c = (char) a;
                if (skip.indexOf(c) != -1) {
                    j++;
                } else {
                    if (idx == index - 1) {
                        sb.append(c);
                    }
                    idx++;
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}