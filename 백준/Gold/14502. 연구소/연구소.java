import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> empties = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int maxSafe = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) empties.add(new int[]{i, j});
                else if (lab[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }

        // 빈칸 중 3개 고르기
        comb(0, 0, new int[3][]);
        System.out.println(maxSafe);
    }

    // 조합 (빈칸 중 3개 선택)
    static void comb(int idx, int depth, int[][] selected) {
        if (depth == 3) {
            simulate(selected);
            return;
        }
        if (idx >= empties.size()) return;

        // 선택
        selected[depth] = empties.get(idx);
        comb(idx + 1, depth + 1, selected);

        // 미선택
        comb(idx + 1, depth, selected);
    }

    // 시뮬레이션
    static void simulate(int[][] walls) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) tmp[i] = lab[i].clone();

        // 벽 세우기
        for (int[] w : walls) tmp[w[0]][w[1]] = 1;

        // 바이러스 퍼뜨리기
        spreadVirus(tmp);

        // 안전 영역 세기
        int safe = countSafe(tmp);
        maxSafe = Math.max(maxSafe, safe);
    }

    // BFS로 바이러스 확산
    static void spreadVirus(int[][] tmp) {
        Queue<int[]> q = new LinkedList<>();
        for (int[] v : viruses) q.add(new int[]{v[0], v[1]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 안전 영역(0의 개수) 세기
    static int countSafe(int[][] tmp) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
