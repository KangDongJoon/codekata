import java.util.*;
class Solution {
    public long solution(long n) {
        String S = Long.toString(n);
        char[] arr = S.toCharArray();
        
        Arrays.sort(arr);
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = arr.length - 1; i >= 0; i--){
            answer.append(arr[i]);
        }
        return Long.parseLong(answer.toString());
    }
}