import java.util.*;

class Solution {
    public String solution(String s) {
        String lowString = s.toLowerCase();
        lowString = lowString.replaceAll(" ", ", ");
        StringBuilder sb = new StringBuilder();
        String[] sArr = lowString.split(" ");

        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals(",")){
                sb.append(sArr[i]);
            }else{
                char c = sArr[i].charAt(0);
                if(c >= 'a' && c <= 'z'){
                    sArr[i] = (char)(c - 32) + sArr[i].substring(1, sArr[i].length());
                    sb.append(sArr[i]);
                }else{
                    sb.append(sArr[i]);
                }
            }
        }
        String answer = sb.toString().replaceAll(",", " ");
        return answer;
    }
}