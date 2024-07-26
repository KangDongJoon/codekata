class Solution {
    public int solution(int n, int m, int[] section) {
        int u = 1;
        int answer = 1;
        
        if(m == 1){
            return section.length;
        }else{
            for(int i = 1; i < section.length; i++){
                int p = section[i] - section[i - 1];
                if(p <= (m - u)){
                    u += p;
                }else{
                    u = 1;
                    answer++;
                }
            }
        }
        return answer;
    }
}