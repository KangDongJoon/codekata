import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;

        // 입력받으면서 가장 큰 나무 높이 찾기
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int min = 0;
        int result = 0;

        // 이진 탐색 시작
        while (min <= max) {
            int mid = (min + max) / 2;

            // 잘린 나무의 총 길이 계산
            long total = 0;
            for (int h : tree) {
                if (h > mid) {
                    total += h - mid;
                }
            }

            if (total >= M) {
                // 목표를 달성할 수 있으면 절단 높이를 올려 탐색
                result = mid; // 가능한 높이 저장
                min = mid + 1;
            } else {
                // 목표를 달성하지 못하면 절단 높이를 낮춰 탐색
                max = mid - 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
