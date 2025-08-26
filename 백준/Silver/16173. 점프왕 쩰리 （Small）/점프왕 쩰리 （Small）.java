import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 변수 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        // 맵 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int dis = map[now[0]][now[1]];

            if (dis == -1) {
                sb.append("HaruHaru");
                return;
            }

            int nx = now[1] + dis;
            int ny = now[0] + dis;

            if (nx < N && !visit[now[0]][nx]) {
                visit[now[0]][nx] = true;
                q.add(new int[]{now[0], nx});
            }

            if (ny < N && !visit[ny][now[1]]) {
                visit[ny][now[1]] = true;
                q.add(new int[]{ny, now[1]});
            }

        }
        sb.append("Hing");
    }
}