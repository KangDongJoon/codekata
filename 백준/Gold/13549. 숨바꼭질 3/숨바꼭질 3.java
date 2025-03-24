import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[] cost = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS(N);
        System.out.println(cost[K] - 1);
    }

    static void BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        cost[start] = 1;

        while (!queue.isEmpty()) {
            int[] nowArr = queue.poll();
            int now = nowArr[0];
            int time = nowArr[1];

            if (now + 1 <= 100000) {
                if (cost[now + 1] == 0 || cost[now + 1] > time + 1) {
                    cost[now + 1] = time + 1;
                    queue.add(new int[]{now + 1, time + 1});
                }
            }

            if (now - 1 >= 0) {
                if (cost[now - 1] == 0 || cost[now - 1] > time + 1) {
                    cost[now - 1] = time + 1;
                    queue.add(new int[]{now - 1, time + 1});
                }
            }

            if (now * 2 <= 100000) {
                if (cost[now * 2] == 0 || cost[now * 2] > time) {
                    cost[now * 2] = time;
                    queue.add(new int[]{now * 2, time});
                }
            }
        }
    }

}
