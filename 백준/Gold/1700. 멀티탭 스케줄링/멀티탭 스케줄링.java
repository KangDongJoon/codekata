import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 멀티탭 구멍 개수
        int K = sc.nextInt(); // 기기 사용 횟수

        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = sc.nextInt();
        }

        Set<Integer> multiTap = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int cur = order[i];

            // 이미 꽂혀 있으면 패스
            if (multiTap.contains(cur)) continue;

            // 빈 자리가 있으면 그냥 꽂기
            if (multiTap.size() < N) {
                multiTap.add(cur);
                continue;
            }

            // 교체해야 하는 경우 → 가장 늦게 쓰이는 것 제거
            int removeCandidate = -1;
            int farthest = -1;

            for (int plugged : multiTap) {
                int nextUse = 0;
                for (int j = i + 1; j < K; j++) {
                    if (order[j] == plugged) {
                        nextUse = j;
                        break;
                    }
                }
                if (nextUse == 0) { // 다시 안 쓰임
                    removeCandidate = plugged;
                    break;
                } else if (nextUse > farthest) {
                    farthest = nextUse;
                    removeCandidate = plugged;
                }
            }

            multiTap.remove(removeCandidate);
            multiTap.add(cur);
            answer++;
        }

        System.out.println(answer);
    }
}
