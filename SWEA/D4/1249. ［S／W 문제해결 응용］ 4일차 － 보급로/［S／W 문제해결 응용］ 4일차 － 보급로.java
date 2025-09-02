import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] dist;
    static int N;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();  // 최단 경로 탐색 실행

            System.out.println("#" + test_case + " " + dist[N - 1][N - 1]);
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == N - 1) return;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = dist[cur.x][cur.y] + map[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
