class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int n = (int)Math.sqrt(i);
            if(Math.pow(n, 2) == i){
                answer -= i;
            }else{
                answer += i;
            }
        }
        return answer;
    }
}