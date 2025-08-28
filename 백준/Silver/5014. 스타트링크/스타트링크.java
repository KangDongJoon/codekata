import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visit;
    static int[] count;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new boolean[F + 1];
        count = new int[F + 1];
        Arrays.fill(count, Integer.MAX_VALUE);

        bw.write(BFS(S));
        bw.flush();
        bw.close();
    }

    static String BFS(int start) {
        visit[start] = true;
        count[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == G) {
                return Integer.toString(count[cur]);
            }

            int up = cur + U;
            int down = cur - D;

            if (up <= F && !visit[up]) {
                visit[up] = true;
                q.add(up);
                int upCount = count[cur] + 1;
                if (upCount < count[up]) {
                    count[up] = upCount;
                }
            }

            if (down > 0 && !visit[down]) {
                visit[down] = true;
                q.add(down);
                int downCount = count[cur] + 1;
                if (downCount < count[down]) {
                    count[down] = downCount;
                }
            }
        }

        return "use the stairs";
    }
}