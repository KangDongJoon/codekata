class Solution {
    public String solution(String x, String y) {
        int[] xli = new int[10];
        int[] yli = new int[10];

        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            xli[c - '0']++;
        }

        for (int i = 0; i < y.length(); i++) {
            char c = y.charAt(i);
            yli[c - '0']++;
        }

        int[] answerArr = new int[10];
        for (int i = 0; i < 10; i++) {
            answerArr[i] = Math.min(xli[i], yli[i]);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < answerArr[i]; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer.toString();
    }
}