class Solution {
    public String solution(int a, int b) {
        int[] year = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int day = 0;
        for(int i = 0; i < a - 1; i++){
            day += year[i];
        }
        day += b;
        
        String answer = week[(day % 7)] ;
        return answer;
    }
}