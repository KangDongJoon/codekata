import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤 크기별 빈도를 저장하는 HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // tangerine 배열의 값들을 순회하며 빈도 계산
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 빈도수만 저장하는 리스트 생성
        List<Integer> frequencyList = new ArrayList<>(map.values());

        // 빈도수 내림차순 정렬
        frequencyList.sort(Collections.reverseOrder());

        int n = 0; // 최소 귤 크기 수
        for (int freq : frequencyList) {
            k -= freq;
            n++;
            // k가 0 이하가 되면 필요한 귤의 수를 충족하였으므로 종료
            if (k <= 0) {
                break;
            }
        }

        return n;
    }
}
