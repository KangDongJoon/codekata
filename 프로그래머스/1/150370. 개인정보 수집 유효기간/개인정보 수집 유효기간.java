import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ansLi = new ArrayList<>();

        Map<String, Integer> termsMap = new HashMap<>();
        for (String t : terms) {
            String[] tArr = t.split(" ");
            termsMap.put(tArr[0], Integer.parseInt(tArr[1]));
        }

        String[] todayArr = today.split("\\.");

        int todays = (Integer.parseInt(todayArr[0]) - 2000) * 12 * 28
                + Integer.parseInt(todayArr[1]) * 28
                + Integer.parseInt(todayArr[2]);

        int idx = 1;
        for (String p : privacies) {
            String k = String.valueOf(p.charAt(p.length() - 1));
            int exp = termsMap.get(k) * 28;
            p = p.substring(2, p.length() - 2);
            String[] pArr = p.split("\\.");
            exp += Integer.parseInt(pArr[0]) * 12 * 28
                    + Integer.parseInt(pArr[1]) * 28
                    + Integer.parseInt(pArr[2]);
            if(todays >= exp){
                ansLi.add(idx);
            }
            idx++;
        }

        int[] answer = new int[ansLi.size()];

        for(int i = 0; i < ansLi.size(); i++){
            answer[i] = ansLi.get(i);
        }
        return answer;
    }
}