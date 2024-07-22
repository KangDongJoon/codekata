import java.util.*;
class Solution {
    public int[] solution(String s) {
		Map<String, Integer> map = new HashMap<>();
		int[] answer = new int [s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			String c  = Character.toString(s.charAt(i));
			if(!map.containsKey(c)) {
				answer[i] = -1;
			}else {
				answer[i] = i - map.get(c);
			}
            map.put(c, i);
		}
        return answer;
    }
}