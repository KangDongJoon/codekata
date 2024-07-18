class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int b = n > m ? n : m;
        int s = n > m ? m : n;
        int tmp = 0;
        
        while(s != 0){
            tmp = s; 
            s = b % s;
            b = tmp;
        }
        
        answer[0] = tmp;
        answer[1] = n * m / tmp;
        
        return answer;
    }
}