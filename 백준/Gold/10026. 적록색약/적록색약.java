import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static String[][] picture;
    static String[][] rgPicture;
    static boolean[][] visit;
    static boolean[][] rgVisit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    static int rgCount = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        picture = new String[N][N];
        rgPicture = new String[N][N];
        visit = new boolean[N][N];
        rgVisit = new boolean[N][N];

        draw();
        divide();

        StringBuilder sb = new StringBuilder();
        sb.append(count).append(" ").append(rgCount);

        System.out.println(sb);
    }

    static void draw() throws IOException {
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                String now = String.valueOf(input.charAt(j));
                picture[i][j] = now;
                if(now.equals("R") || now.equals("G")){
                    rgPicture[i][j] = "R";
                }else {
                    rgPicture[i][j] = now;
                }
            }
        }
    }

    static void divide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    BFS(i, j);
                    count++;
                }

                if(!rgVisit[i][j]){
                    RGBFS(i, j);
                    rgCount++;
                }
            }
        }
    }

    static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        String nowColor = picture[y][x];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dX = now[1] + dx[i];
                int dY = now[0] + dy[i];

                if (dX < 0 || dY < 0 || dX >= N || dY >= N) {
                    continue;
                }

                if (picture[dY][dX].equals(nowColor) && !visit[dY][dX]) {
                    queue.add(new int[]{dY, dX});
                    visit[dY][dX] = true;
                }
            }
        }
    }

    static void RGBFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        rgVisit[y][x] = true;
        String nowColor = rgPicture[y][x];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dX = now[1] + dx[i];
                int dY = now[0] + dy[i];

                if (dX < 0 || dY < 0 || dX >= N || dY >= N) {
                    continue;
                }

                if (rgPicture[dY][dX].equals(nowColor) && !rgVisit[dY][dX]) {
                    queue.add(new int[]{dY, dX});
                    rgVisit[dY][dX] = true;
                }
            }
        }
    }
}