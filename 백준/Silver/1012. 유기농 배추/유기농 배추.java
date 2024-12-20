import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int M, N;
    static int worm;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            arr = new int[N][M];
            worm = 0;

            // 배추 심기
            for (int i = 0; i < K; i++) {
                String[] pos = br.readLine().split(" ");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);
                arr[y][x] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] == 1) {
                        worm++;
                        clear(y, x);
                    }
                }
            }

            bw.write(worm + "\n");
        }

        bw.flush();
    }

    static void clear(int y, int x) {
        if (x < 0 || y < 0 || x >= M || y >= N || arr[y][x] == 0) {
            return;
        }

        arr[y][x] = 0;

        // 상하좌우 탐색
        clear(y - 1, x);
        clear(y + 1, x);
        clear(y, x - 1);
        clear(y, x + 1);
    }
}
