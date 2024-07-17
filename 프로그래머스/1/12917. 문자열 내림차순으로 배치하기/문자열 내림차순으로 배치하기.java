import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = new String[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[i] = String.valueOf(c);
        }
        Arrays.sort(arr);
        String answer = "";
        for(int j = arr.length - 1; j >=0; j--){
            answer += arr[j];
        }
        return answer;
    }
}