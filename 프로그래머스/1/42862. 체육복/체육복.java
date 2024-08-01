import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> reserveLi = new ArrayList<>();
        for(int i = 0; i < reserve.length; i++){
            reserveLi.add(reserve[i]);
        }
        
        int cnt = n - lost.length;
        
        for(int i = 0; i < lost.length; i++){
            if(reserveLi.contains(lost[i])){
                reserveLi.set(reserveLi.indexOf(lost[i]), -1);
                lost[i] = -1;
                cnt++;
            }
        }
        
        for(int l : lost){
            if(reserveLi.contains(l - 1)){
                reserveLi.set(reserveLi.indexOf(l - 1), -1);
                cnt++;
            }else if(reserveLi.contains(l + 1)){
                reserveLi.set(reserveLi.indexOf(l + 1), -1);
                cnt++;
            }
        }
        return cnt;
    }
}