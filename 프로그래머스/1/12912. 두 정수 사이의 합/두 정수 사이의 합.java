class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b){
            return a;
        }else{
            int s = a > b ? b : a;
            int e = a > b ? a : b;
            for(int i = s; i <= e; i++){
            answer += i;
            }
        }
        return answer;
    }
}