import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static int[][] graph;
    static int[][] dist;
    static boolean[][] visit;
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        createGraph(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    BFS(i, j);
                }
            }
        }

        bw.write(printDist());
        bw.flush();
    }

    static void createGraph(int n, int m) throws IOException {
        graph = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dX = now[1] + dx[i];
                int dY = now[0] + dy[i];

                if (dX < 0 || dY < 0 || dX >= m || dY >= n) {
                    continue;
                }

                if (graph[dY][dX] == 1 && !visit[dY][dX]) {
                    queue.add(new int[]{dY, dX});
                    dist[dY][dX] = dist[now[0]][now[1]] + 1;
                    visit[dY][dX] = true;
                }
            }
        }
    }

    static String printDist() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visit[i][j]) {
                    sb.append(dist[i][j]).append(" ");
                }else if(graph[i][j] == 1 && !visit[i][j]){
                    sb.append(-1).append(" ");
                }else{
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
