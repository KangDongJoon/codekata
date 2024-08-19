import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> idLi = Arrays.asList(id_list);
        Map<String, Integer> idMap = new HashMap<>();
        Set<String> reSet = new HashSet<>();
        List<String> banId = new ArrayList<>();
        int[] answer = new int[id_list.length];

        for (String s : id_list) {
            idMap.put(s, 0);
        }

        for (String r : report) {
            reSet.add(r);
        }

        for (String s : reSet) {
            String[] repot = s.split(" ");
            idMap.put(repot[1], idMap.get(repot[1]) + 1);
        }

        for (String key : idMap.keySet()) {
            if (idMap.get(key) >= k) {
                banId.add(key);
            }
        }

        for (String r : reSet) {
            String[] rArr = r.split(" ");
            if(banId.contains(rArr[1])){
                answer[idLi.indexOf(rArr[0])]++;
            }
        }
        return answer;
    }
}