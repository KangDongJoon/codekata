class Solution {
    public int solution(int[] citations) {
    int answer = 0;
        int j = 1;

        while (j <= citations.length) {
            int up = 0;
            for (int i = 0; i < citations.length; i++) {
                int c = citations[i];
                if (c >= j) {
                    up++;
                }
            }
            if (up >= j) {
                if (j > answer) {
                    answer = j;
                }
            }
            j++;
        }
        return answer;
    }
}