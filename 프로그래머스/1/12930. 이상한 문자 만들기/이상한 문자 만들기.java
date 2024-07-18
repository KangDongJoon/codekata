class Solution {
    public String solution(String s) {
		StringBuilder sb = new StringBuilder();
        int j = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') {
				sb.append(c);
                j = 0;
			}else {
				if(j % 2 == 0) {
					sb.append(Character.toUpperCase(c));
                    j++;
				}else {
					sb.append(Character.toLowerCase(c));
                    j++;
				}
			}
		}
        return sb.toString();
    }
}