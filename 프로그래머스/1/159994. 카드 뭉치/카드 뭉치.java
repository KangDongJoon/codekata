class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int c1 = 0;
		int c2 = 0;
		for(int i = 0; i < goal.length; i++) {
			if(goal[i].equals(cards1[c1])) {
                if(c1 < cards1.length - 1){
                    c1++;    
                }
			}else if(goal[i].equals(cards2[c2])) {
                if(c2 < cards2.length - 1){
                    c2++;
                }
			}else {
				return "No";
			}
		}
        return answer;
    }
}