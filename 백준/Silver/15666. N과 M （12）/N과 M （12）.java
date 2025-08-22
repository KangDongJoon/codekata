import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬

        dfs(0, 0);

        System.out.print(sb.toString());
    }

    // depth: 현재 수열의 길이, start: 시작 인덱스
    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 같은 depth에서 중복 방지
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) continue; // 같은 숫자 건너뛰기
            result[depth] = arr[i];
            prev = arr[i];
            dfs(depth + 1, i); // 중복 허용 → i
        }
    }
}
