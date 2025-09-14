import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long answer = 0;
        for (int j = 0; j < T; j++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> q = new LinkedList<>();
            int max = arr[N - 1];

            for (int k = N - 2; k >= 0; k--) {
                int now = arr[k];

                if (now >= max) {
                    answer = sell(q, answer, max);
                    max = now;
                } else {
                    q.add(now);
                }
            }

            if (!q.isEmpty()) {
                answer = sell(q, answer, max);
            }
            sb.append(answer).append("\n");
            answer = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long sell(Queue<Integer> q, long answer, int max) {
        while (!q.isEmpty()) {
            answer += (max - q.poll());
        }

        return answer;
    }
}
