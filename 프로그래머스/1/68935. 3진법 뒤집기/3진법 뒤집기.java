class Solution {
    public int solution(int n) {
        return conv(n);
    }
    
    public static int conv(int a) {	
		StringBuilder sb = new StringBuilder();
		while(a > 2) {
			sb.append(a % 3);
			a /= 3;
		}
		sb.append(a);
		
		int answer = 0;
		for(int i = 0; i < sb.length(); i++) {
			char c = (sb.toString()).charAt(i);
			answer += (c - '0') * Math.pow(3, sb.length() - 1 - i);
		}
		return answer;
    }
}