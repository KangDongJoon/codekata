class Solution {
    public boolean solution(String s) {
        int n = s.length();
        if(n == 4 || n == 6){
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c  < '0' || c > '9'){
                    return false;
                }        
            }
        }else {
            return false;
        }
        return true;
    }
}