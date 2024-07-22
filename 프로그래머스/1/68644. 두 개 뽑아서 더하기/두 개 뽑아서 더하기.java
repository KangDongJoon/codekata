import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> li = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				int n  = numbers[i] + numbers[j];
				if(!li.contains(n)) {
					li.add(n);	
				}
			}
		}
		
		int[] answer = new int[li.size()];
		
		for(int q = 0; q < answer.length; q++) {
			answer[q] = li.get(q);
		}
		
		Arrays.sort(answer);
        return answer;
    }
}