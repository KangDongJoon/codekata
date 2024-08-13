import java.util.*;
class Solution {
    static Map<String, Integer> rankMap = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        for(int i = 0; i < players.length; i++){
            rankMap.put(players[i], i);
        }

        for (String c : callings) {
            int i = rankMap.get(c);
            swap(players, i);
        }
        return players;
    }

    public static void swap(String[] players, int idx){
        String tmp = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = tmp;

        rankMap.put(players[idx], rankMap.get(players[idx]) + 1);
        rankMap.put(players[idx - 1], rankMap.get(players[idx - 1]) - 1);
    }
}