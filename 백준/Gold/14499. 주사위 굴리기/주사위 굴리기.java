import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, x, y, K;
    static int[][] map;
    static int[] command;

    //     1 2 3 4
    // 방향 동서북남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    // 주사위
    static int[] dice;

    public static void main(String[] args) throws IOException {
        input();
        roll();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 생성
        command = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int q = 0; q < K; q++) {
            command[q] = Integer.parseInt(st.nextToken());
        }

        // 주사위 생성
        // 0 = 2, 1 = 1, 2 = 5, 3 = 6, 4 = 4, 5 = 3
        //  2
        //4 1 3
        //  5
        //  6
        dice = new int[6];

    }

    static void roll() {
        for (int i : command) {
            int nx = x + dx[i - 1];
            int ny = y + dy[i - 1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                swap(i);
                sb.append(dice[1]).append("\n");
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[3];
                } else {
                    dice[3] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;

            }
        }
    }

    static void swap(int d) {
        // 주사위 배열
        // 0 = 2, 1 = 1, 2 = 5, 3 = 6, 4 = 4, 5 = 3
        //  2
        //4 1 3
        //  5
        //  6
        int temp;
        switch (d) {
            //동
            case 1:
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;
                break;
            // 서
            case 2:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[4];
                dice[4] = temp;
                break;
            // 북
            case 3:
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[0];
                dice[0] = temp;
                break;
            // 남
            case 4:
                temp = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[2];
                dice[2] = temp;
                break;
        }
    }
}