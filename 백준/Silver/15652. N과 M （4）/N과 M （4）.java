import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            seq[depth] = i;
            dfs(depth + 1, i); // i부터 시작 -> 비내림차순(중복 허용)
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        dfs(0, 1);
        System.out.print(sb.toString());
    }
}
