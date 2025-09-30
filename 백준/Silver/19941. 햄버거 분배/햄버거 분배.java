import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().trim().toCharArray();

        boolean[] used = new boolean[N]; // 햄버거 사용 여부
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] != 'P') continue; // 사람이 아니면 건너뜀
            int left = Math.max(0, i - K);
            int right = Math.min(N - 1, i + K);
            for (int j = left; j <= right; j++) {
                if (arr[j] == 'H' && !used[j]) {
                    used[j] = true;
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
