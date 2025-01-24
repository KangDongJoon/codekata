import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static String[][] campus;
    static boolean[][] visit;
    static int N;
    static int M;
    static int count;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] start;

    public static void main(String[] args) throws IOException {

        input();

        BFS(start[0], start[1]);

        if (count == 0) {
            bw.write("TT");
        } else {
            bw.write(Integer.toString(count));
        }
        bw.flush();

    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = String.valueOf(read.charAt(j));
                if(campus[i][j].equals("I")){
                    start = new int[] {i, j};
                }
            }
        }
    }

    static void BFS(int y, int x) {
        count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dX = now[1] + dx[i];
                int dY = now[0] + dy[i];

                if (dX < 0 || dY < 0 || dX >= M || dY >= N || visit[dY][dX]) {
                    continue;
                }

                String nextS = campus[dY][dX];

                if (nextS.equals("P") || nextS.equals("O")) {
                    if (nextS.equals("P")) {
                        count++;
                    }
                    queue.add(new int[]{dY, dX});
                    visit[dY][dX] = true;
                }
            }
        }
    }
}