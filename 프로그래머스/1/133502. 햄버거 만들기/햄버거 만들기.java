import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> li = new ArrayList<>();
        for (int n : ingredient) {
         li.add(n);
        }

        int i = 0;
        while (i <= li.size() - 4) {
            if (li.get(i) == 1 && li.get(i + 1) == 2 && li.get(i + 2) == 3 && li.get(i + 3) == 1) {
                answer++;
                for (int j = 0; j < 4; j++) {
                    li.remove(i);
                }
                i = Math.max(0, i - 3); // 인덱스 재설정
            } else {
                i++;
            }
        }
        return answer;
    }
}