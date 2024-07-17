import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> li = new ArrayList<>();
        for(int n : arr){
            if(n % divisor == 0){
                li.add(n);
            }
        }
        if(li.isEmpty()){
            li.add(-1);
        }
        int[] answer = new int[li.size()];
        
        for(int i = 0; i < li.size(); i++){
            answer[i] = li.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}