import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> li = new ArrayList<>();
        Arrays.sort(lottos);

        int joker = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                li.add(lottos[i]);
            } else {
                joker++;
            }
        }

        int cnt = 0;
        for (int n : win_nums) {
            if (li.contains(n)) {
                cnt++;
            }
        }
        int min = cnt;
        int max = joker + cnt;

        int[] answer = new int[2];

        if(max < 2){
            answer[0] = 6;
            answer[1] = 6;
        }else {
            answer[0] = 7 - max;
            answer[1] = cnt >= 1 ? 7 - min : 6;
        }
        return answer;
    }
}
