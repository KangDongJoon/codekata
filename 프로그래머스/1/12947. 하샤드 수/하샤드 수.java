class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String S = Integer.toString(x);
        int sum = 0;
        
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            sum += c - '0';
        }
        if(x % sum != 0){
            answer = false;
        }
        return answer;
    }
}
