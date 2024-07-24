import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int sl = score.length;
        Arrays.sort(score);

        int answer = 0;
        int i = sl - m;
        while (i >= 0){
            answer += score[i] * m;
            i -= m;
        }
        return answer;
    }
}