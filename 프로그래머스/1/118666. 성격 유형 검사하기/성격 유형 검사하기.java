import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>(Map.of(
                "R", 0, "T", 0,
                "C", 0, "F", 0,
                "J", 0, "M", 0,
                "A", 0, "N", 0
        ));
        for (int i = 0; i < choices.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int c = choices[i];

            if (c < 4) {
                map.put(Character.toString(a), map.get(Character.toString(a)) + (4 - c));
            } else if (c > 4) {
                map.put(Character.toString(b), map.get(Character.toString(b)) + (c - 4));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.get("R") >= map.get("T") ? "R" : "T");
        sb.append(map.get("C") >= map.get("F") ? "C" : "F");
        sb.append(map.get("J") >= map.get("M") ? "J" : "M");
        sb.append(map.get("A") >= map.get("N") ? "A" : "N");
        
        return sb.toString();
    }
}