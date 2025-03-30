import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C;
    static String[][] graph;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        backtracking(0, 0, 1);
        System.out.println(max);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R][C];
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            String read = br.readLine();
            for (int j = 0; j < read.length(); j++) {
                graph[i][j] = String.valueOf(read.charAt(j));
            }
        }
    }

    static void backtracking(int x, int y, int dist) {
        map.put(graph[x][y], true);
        max = Math.max(max, dist);
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || map.containsKey(graph[nextX][nextY])) {
                continue;
            }
            backtracking(nextX, nextY, dist + 1);
            map.remove(graph[nextX][nextY]);
        }
    }
}
