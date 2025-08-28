import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] map;
    static int N;
    static boolean[][] deep;
    static boolean[][] visit;
    static int max;
    static int answer = 0;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        // 입력 및 변수 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n > max) {
                    max = n;
                }
            }
        }

        // 강수량 별 안전구역 계산
        for (int k = 0; k <= max; k++) {
            deep = new boolean[N][N]; // 침수 지역 초기화
            Deep(k); // 침수 진행
            visit = new boolean[N][N]; // 방문 초기화
            int safeZone = search(); // 안전구역 탐색
            if (safeZone > answer) {
                answer = safeZone;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static void BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[1] + dx[i];
                int nY = cur[0] + dy[i];

                if (nX >= 0 && nX < N
                        && nY >= 0 && nY < N
                        && !deep[nY][nX]
                        && !visit[nY][nX]) {
                    q.add(new int[]{nY, nX});
                    visit[nY][nX] = true;
                }
            }
        }
    }

    static void Deep(int rain) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= rain) {
                    deep[i][j] = true;
                }
            }
        }
    }

    static int search() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!deep[i][j] && !visit[i][j]) {
                    BFS(i, j); // 인접한 안전구역은 한 영역으로 취급
                    count++; // 모든 인접 구역 확인이 끝나면 카운터 증가
                }
            }
        }
        return count;
    }

}