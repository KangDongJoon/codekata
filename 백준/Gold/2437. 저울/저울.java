import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        long target = 1;
        for (int w : weight) {
            if (w > target) break;
            target += w;
        }

        System.out.println(target);
    }
}
