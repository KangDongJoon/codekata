import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int r, c, d;
    static int[][] map;
    static boolean[][] clean;

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0}; // 행 이동
    static int[] dy = {0, 1, 0, -1}; // 열 이동

    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        clean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    static void simulate() {
        while (true) {

            // 1. 현재 위치 청소
            if (!clean[r][c] && map[r][c] == 0) {
                clean[r][c] = true;
                count++;
            }

            boolean moved = false;

            // 2. 반시계 회전하면서 청소할 칸 탐색
            for (int i = 0; i < 4; i++) {
                // 반시계 90° 회전
                d = (d + 3) % 4;
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M
                        && map[nr][nc] == 0 && !clean[nr][nc]) {
                    // 전진
                    r = nr;
                    c = nc;
                    moved = true;
                    break; // 새로운 위치에서 다시 1번부터 반복
                }
            }

            if (moved) continue;

            // 3. 후진
            int back = (d + 2) % 4;
            int br = r + dx[back];
            int bc = c + dy[back];

            if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] == 0) {
                r = br;
                c = bc;
            } else {
                // 후진 불가 → 종료
                break;
            }
        }
    }
}
