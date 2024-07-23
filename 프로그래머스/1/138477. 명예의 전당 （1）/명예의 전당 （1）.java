import java.util.Arrays;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] rank = new int[k];
		int[] answer = new int[score.length];
		
		for(int i = 0; i < score.length; i++) {
			if(rank[0] < score[i]) {
				rank[0] = score[i];
			}
			Arrays.sort(rank);
			if(i < k) {
				answer[i] = rank[k-(i+1)];
			}else {
				answer[i] = rank[0];
			}
		}
        return answer;
    }
}