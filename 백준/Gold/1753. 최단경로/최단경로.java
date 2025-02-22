import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int V, E, start;
    static List<Node>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        var();
        graph();
        dijkstra(start);

        for (int i = 1; i < distance.length; i++) {
            int n = distance[i];
            if (n == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else
                System.out.println(n);
        }
    }

    static void var() throws IOException {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
    }

    static void graph() throws IOException {
        graph = new ArrayList[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, d));
        }
    }

    static class Node {

        private int p;
        private int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.d));
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIndex = now.p;
            int dist = now.d;
            if (distance[nowIndex] < dist) continue;

            for (int i = 0; i < graph[nowIndex].size(); i++) {
                Node next = graph[nowIndex].get(i);
                int nextIndex = next.p;
                int nextDist = next.d;

                if (distance[nextIndex] > distance[nowIndex] + nextDist) {
                    distance[nextIndex] = distance[nowIndex] + nextDist;
                    pq.add(new Node(nextIndex, distance[nextIndex]));

                }
            }
        }
    }
}