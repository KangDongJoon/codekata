import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int V, E, K;
    static List<Node>[] graph;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < V + 1; i++) {
            int n = dist[i];
            if (n == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(n).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visit = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int j = 0; j < E; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(next, dist));
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.next;
            int nowDist = nowNode.dist;

            if (visit[now]) continue;

            visit[now] = true;
            for (Node node : graph[now]) {
                int next = node.next;
                int nextDist = node.dist;

                if (dist[now] + nextDist < dist[next]) {
                    dist[next] = dist[now] + nextDist;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }


    }

    static class Node {
        int next;
        int dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

}
