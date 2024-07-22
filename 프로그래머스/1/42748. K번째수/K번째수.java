import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int a = 0; a < commands.length; a++) {
				int i = commands[a][0] - 1;
				int j = commands[a][1] - 1;
				int k = commands[a][2] - 1;
				int[] tmp = new int[j - i + 1];
				for(int b = 0; b < tmp.length; b++) {
					tmp[b] = array[b + i];
			}
				Arrays.sort(tmp);
				answer[a] = tmp[k];
		}
        return answer;
    }
}