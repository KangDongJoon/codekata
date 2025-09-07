import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b});
            }

            list.sort(Comparator.comparing(a -> a[0]));

            int count = N;
            int max = list.get(0)[1];

            for (int k = 1; k < N; k++) {
                int now = list.get(k)[1];

                if (max < now) {
                    count--;
                }

                if (max > now) {
                    max = now;
                }

            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}