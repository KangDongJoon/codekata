class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int cnt = 0;
        int y2 = 0;
        answer[1] = Integer.MAX_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#'){
                    y2 = i;
                    if(cnt == 0) {
                        answer[0] = i;
                    }
                    if(answer[1] >= j){
                        answer[1] = j;
                    }
                    if(answer[3] <= j + 1){
                        answer[3] = j + 1;
                    }
                    cnt++;
                }
            }
        }
        answer[2] = y2 + 1;
        
        if(cnt == 1){
            answer[2] = answer[0] + 1;
            answer[3] = answer[1] + 1;
        }
        return answer;
    }
}