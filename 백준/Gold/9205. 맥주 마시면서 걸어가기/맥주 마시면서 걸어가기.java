import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t;
    static int n;
    static List<Point> xy;
    static boolean[] visit;
    static int beer;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            xy = new ArrayList<>();
            beer = 20;
            testCase();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void testCase() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy.add(new Point(x, y));
        }

        sb.append(bfs()).append("\n");
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int distance(Point next) {
            int dx = Math.abs(next.x - this.x);
            int dy = Math.abs(next.y - this.y);
            return dx + dy;
        }
    }

    static String bfs() {
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[n + 2];
        
        q.add(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == n + 1) {
                return "happy";
            }

            for (int i = 0; i < n + 2; i++) {
                if (!visit[i]) {
                    if (xy.get(now).distance(xy.get(i)) <= 1000) {
                        visit[i] = true;
                        q.add(i);
                    }
                }
            }
        }

        return "sad";
    }
}