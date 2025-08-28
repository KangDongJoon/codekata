import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 현재 빙산 위치만 관리
    static List<int[]> iceList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    iceList.add(new int[]{i, j});
                }
            }
        }

        int year = 0;
        while (true) {
            int areaCount = countArea();
            if (areaCount >= 2) break; // 두 덩어리 이상
            if (iceList.isEmpty()) {   // 다 녹음
                year = 0;
                break;
            }
            melt();
            year++;
        }

        bw.write(Integer.toString(year));
        bw.flush();
        bw.close();
    }

    // 빙산 녹이기
    static void melt() {
        int[][] meltAmount = new int[N][M];
        // 현재 빙산 위치만 돌면서 주변 바다 체크
        for (int[] ice : iceList) {
            int y = ice[0], x = ice[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
                    meltAmount[y][x]++;
                }
            }
        }

        // 빙산 녹이면서 새 리스트 갱신
        List<int[]> newIceList = new ArrayList<>();
        for (int[] ice : iceList) {
            int y = ice[0], x = ice[1];
            map[y][x] = Math.max(0, map[y][x] - meltAmount[y][x]);
            if (map[y][x] > 0) {
                newIceList.add(new int[]{y, x});
            }
        }
        iceList = newIceList;
    }

    // 빙산 덩어리 개수 세기
    static int countArea() {
        visit = new boolean[N][M];
        int cnt = 0;
        for (int[] ice : iceList) {
            int y = ice[0], x = ice[1];
            if (!visit[y][x]) {
                bfs(y, x);
                cnt++;
            }
        }
        return cnt;
    }

    static void bfs(int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});
        visit[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M
                        && map[ny][nx] > 0 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
