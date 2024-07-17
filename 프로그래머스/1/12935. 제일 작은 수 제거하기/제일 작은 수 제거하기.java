import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }else{
            int[] answer = new int[arr.length - 1];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++){
                if(min > arr[i]){
                    min = arr[i];
                }
            }
            int q = 0;
            for(int j = 0; j < answer.length; j++){
                if(arr[q] == min){
                    q++;
                    answer[j] = arr[q];
                    q++;
                }else{
                    answer[j]= arr[q];
                    q++;
                }
            }
            return answer;
        }
    }
}