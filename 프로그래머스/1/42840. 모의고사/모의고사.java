import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] m1 = {1, 2, 3, 4, 5}; // 5
        int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);

        for(int i = 0; i < answers.length; i++){
            if(m1[i % 5] == answers[i]){
                map.put(1, map.get(1) + 1);
            }
            if(m2[i % 8] == answers[i]){
                map.put(2, map.get(2) + 1);
            }
            if(m3[i % 10] == answers[i]){
                map.put(3, map.get(3) + 1);
            }
        }

        int max = Math.max(map.get(1), Math.max(map.get(2), map.get(3)));

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            if(map.get(i) == max){
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}