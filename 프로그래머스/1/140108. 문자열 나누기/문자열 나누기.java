class Solution {
    public int solution(String S) {
        int answer = 0;

        int i = 0;
        outLoop:
        while(i < S.length()) {
            if(i == S.length() - 1){
                answer++;
                break;
            }
            char x = S.charAt(i);
            int xCnt = 1;
            int yCnt = 0;
            for(int j = i + 1; j < S.length(); j++){
                char y = S.charAt(j);
                if(x == y){
                    xCnt++;
                }else{
                    yCnt++;
                }
                if(xCnt == yCnt) {
                    answer++;
                    if (j < S.length() - 1) {
                        i = j + 1;
                        break;
                    }else{
                        break outLoop;
                    }
                }else if(xCnt != yCnt && j == S.length() - 1){
                    answer++;
                    break outLoop;
                }
            }
        }
        return answer;
    }
}