class Solution {
    public int solution(int n) {
        int f0 = 0;
        int f1 = 1;
        int answer = 0;

        int i = 2;
        while(i <= n){
            answer  = (f0 + f1) % 1234567;

            f0 = f1 % 1234567;
            f1 = answer;
            i++;
        }
        return answer;
    }
}