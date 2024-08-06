import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자에 대한 최소 키 입력 수를 저장하는 맵을 생성
        Map<Character, Integer> keyPressMap = new HashMap<>();
        
        // 키맵을 분석하여 각 문자의 최소 키 입력 수를 계산
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                // 해당 문자가 처음 발견되거나 더 적은 입력 수로 발견되었을 때 업데이트
                keyPressMap.put(c, Math.min(keyPressMap.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }

        int[] result = new int[targets.length];
        
        // 각 타겟 문자열에 대해 최소 키 입력 수 계산
        for (int i = 0; i < targets.length; i++) {
            int answer = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (keyPressMap.containsKey(c)) {
                    answer += keyPressMap.get(c);
                } else {
                    answer = -1; // 해당 문자가 키맵에 존재하지 않음
                    break;
                }
            }
            result[i] = answer;
        }
        
        return result;
    }
}
