import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        // 첫 줄 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(st.nextToken());
            maxDP[i] = val;
            minDP[i] = val;
        }

        // 두 번째 줄부터 N번째 줄까지 처리
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 이전 값 복사
            int max0 = maxDP[0], max1 = maxDP[1], max2 = maxDP[2];
            int min0 = minDP[0], min1 = minDP[1], min2 = minDP[2];

            // 최대값 DP 갱신
            int[] newMax = new int[3];
            newMax[0] = a + Math.max(max0, max1);
            newMax[1] = b + Math.max(Math.max(max0, max1), max2);
            newMax[2] = c + Math.max(max1, max2);

            // 최소값 DP 갱신
            int[] newMin = new int[3];
            newMin[0] = a + Math.min(min0, min1);
            newMin[1] = b + Math.min(Math.min(min0, min1), min2);
            newMin[2] = c + Math.min(min1, min2);

            // 현재 dp로 덮어쓰기
            maxDP = newMax;
            minDP = newMin;
        }

        int maxResult = Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]);
        int minResult = Math.min(Math.min(minDP[0], minDP[1]), minDP[2]);

        System.out.println(maxResult + " " + minResult);
    }
}
