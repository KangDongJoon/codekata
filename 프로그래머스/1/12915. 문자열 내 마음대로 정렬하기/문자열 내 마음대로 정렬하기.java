import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            char c = strings[i].charAt(n);
            String tmp = strings[i];
            answer[i] = c + tmp;
        }
        Arrays.sort(answer);
        for(int j = 0; j < answer.length; j++){
            String tmp = answer[j].substring(1, answer[j].length());
            answer[j] = tmp;
        }
        return answer;
    }
}