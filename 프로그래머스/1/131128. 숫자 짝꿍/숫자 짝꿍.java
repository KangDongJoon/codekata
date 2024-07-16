import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        List<Integer> co = new ArrayList<>();
        Map<Integer, Integer> xliCount = new HashMap<>();
        Map<Integer, Integer> yliCount = new HashMap<>();
        
        // X의 숫자를 세기
        for (int i = 0; i < X.length(); i++) {
            int num = Character.getNumericValue(X.charAt(i));
            xliCount.put(num, xliCount.getOrDefault(num, 0) + 1);
        }

        // Y의 숫자를 세기
        for (int i = 0; i < Y.length(); i++) {
            int num = Character.getNumericValue(Y.charAt(i));
            yliCount.put(num, yliCount.getOrDefault(num, 0) + 1);
        }
        
        // 공통 숫자를 찾아 리스트에 추가
        for (Map.Entry<Integer, Integer> entry : xliCount.entrySet()) {
            int num = entry.getKey();
            int count = Math.min(entry.getValue(), yliCount.getOrDefault(num, 0));
            for (int i = 0; i < count; i++) {
                co.add(num);
            }
        }
        
        // 정렬 후 역순
        Collections.sort(co);
        Collections.reverse(co);
        
        StringBuilder sb = new StringBuilder();
        if (co.isEmpty()) {
            return "-1";
        } else if (co.size() > 1 && co.get(0) == 0 && co.get(1) == 0) {
            return "0"; // co에 0만 있는 경우
        } else {
            for (int a : co) {
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
