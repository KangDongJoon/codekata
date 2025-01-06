import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int N;
    static int[][] box;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        createBox();
        BFS();

        System.out.println(checkBox());

    }

    static void createBox() throws IOException {

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                box[i][j] = input;
                if (input == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

    }


    static void BFS() {

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];

            for (int i = 0; i < 4; i++) {
                int dX = x + dx[i];
                int dY = y + dy[i];

                if (dX < 0 || dY < 0 || dX >= M || dY >= N) {
                    continue;
                }

                if (box[dY][dX] == 0) {
                    box[dY][dX] = box[y][x] + 1;
                    queue.add(new int[]{dY, dX});
                }
            }
        }

    }

    static int checkBox() {

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                } else {
                    count = Math.max(count, box[i][j]);
                }
            }
        }

        return count - 1;
    }
}
