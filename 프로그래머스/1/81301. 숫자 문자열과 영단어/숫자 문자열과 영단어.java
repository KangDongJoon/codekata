class Solution {
    public int solution(String s) {
        String answer = "";
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == 'z'){
                answer += "0";
                i += 4;
            }else if(c == 'o'){
                answer += "1";
                i += 3;
            }else if(c == 't'){
                char d = s.charAt(i + 1);
                if(d == 'w'){
                    answer += "2";
                    i += 3;
                }else{
                    answer += "3";
                    i += 5;
                }
            }else if(c == 'f'){
                char d = s.charAt(i + 1);
                if(d == 'o'){
                    answer += "4";
                    i += 4;
                }else{
                    answer += "5";
                    i += 4;
                }
            }else if(c == 's'){
                char d = s.charAt(i + 1);
                if(d == 'i'){
                    answer += "6";
                    i += 3;
                }else{
                    answer += "7";
                    i += 5;
                }
            }else if(c == 'e'){
                answer += "8";
                i += 5;
            }else if(c == 'n'){
                answer += "9";
                i += 4;
            }else {
                answer += c;
                i++;
            }
        }
        return Integer.parseInt(answer);
    }
}