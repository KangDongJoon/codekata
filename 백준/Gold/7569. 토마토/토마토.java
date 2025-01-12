import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M; // 가로
    static int N; // 세로
    static int H; // 높이 (층)
    static int[][][] box; // 3D 배열로 수정
    static boolean[][][] visit; // 3D 배열로 수정
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M]; // 3D 배열로 변경
        visit = new boolean[H][N][M]; // 3D 배열로 변경

        createBox();

        // 큐에 익은 토마토들 넣기
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j}); // 큐에 층, 행, 열 인덱스 넣기
                    }
                }
            }
        }

        BFS();

        searchBox();
    }

    static void createBox() throws IOException {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int h = now[0]; // 현재 층
            int i = now[1]; // 현재 행
            int j = now[2]; // 현재 열

            // 4방향 (좌, 우, 상, 하) 탐색
            for (int k = 0; k < 4; k++) {
                int newX = j + dx[k];
                int newY = i + dy[k];

                if (newX < 0 || newY < 0 || newX >= M || newY >= N) {
                    continue; // 범위 벗어나면 skip
                }

                if (box[h][newY][newX] == 0) {  // 익지 않은 토마토 발견
                    box[h][newY][newX] = box[h][i][j] + 1;
                    queue.add(new int[]{h, newY, newX});
                }
            }

            // 위층 (h-1)
            if (h > 0 && box[h-1][i][j] == 0) {
                box[h-1][i][j] = box[h][i][j] + 1;
                queue.add(new int[]{h-1, i, j});
            }

            // 아래층 (h+1)
            if (h < H-1 && box[h+1][i][j] == 0) {
                box[h+1][i][j] = box[h][i][j] + 1;
                queue.add(new int[]{h+1, i, j});
            }
        }
    }

    static void searchBox() {
        int max = 0;
        boolean allRipe = true;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) {
                        allRipe = false;  // 익지 않은 토마토가 하나라도 있으면
                    } else {
                        max = Math.max(max, box[h][i][j]);
                    }
                }
            }
        }

        if (allRipe) {
            System.out.println(max - 1);  // 마지막 익은 날 - 1을 출력
        } else {
            System.out.println(-1);  // 익지 않은 토마토가 있으면 -1 출력
        }
    }
}
