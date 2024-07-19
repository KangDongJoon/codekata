class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char shc = c;
            if(c == ' '){
                answer += " ";
            }else {
                if(Character.isLowerCase(c)){
                   shc = (char)((c - 'a' + n) % 26 + 'a');
                }else {
                    shc = (char)((c - 'A' + n) % 26 + 'A');
                }
                answer += shc;
            }
        }
        return answer;
    }
}