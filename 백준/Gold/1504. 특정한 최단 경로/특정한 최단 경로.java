import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, E;
    static List<Node>[] graph;
    static int[] distance;
    static int v1, v2;


    public static void main(String[] args) throws IOException {
        int INF = (800 * 1000) * 2 + 1000;
        init();

        dijkstra(1);
        int a1 = distance[v1];
        int a2 = distance[v2];
        dijkstra(v1);
        int b1 = distance[v2];
        int b2 = distance[N];
        dijkstra(v2);
        int c1 = distance[v1];
        int c2 = distance[N];

        int answer1 = a1 + b1 + c2;
        int answer2 = a2 + c1 + b2;
        if (answer1 < answer2) {
            if (a1 > INF || b1 > INF || c2 > INF) {
                System.out.println(-1);
            } else {
                System.out.println(answer1);
            }
        } else {
            if (a2 > INF || c1 > INF || b2 > INF) {
                System.out.println(-1);
            } else {
                System.out.println(answer2);
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        input();
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }

    static void input() throws IOException {
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
    }

    static class Node {
        private int node;
        private int dist;

        public Node(int a, int b) {
            this.node = a;
            this.dist = b;
        }
    }

    static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(n -> n.dist)));
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIndex = now.node;
            int dist = now.dist;
            if (distance[nowIndex] < dist) continue;

            for (int i = 0; i < graph[nowIndex].size(); i++) {
                Node next = graph[nowIndex].get(i);
                int nextIndex = next.node;
                int nextDist = next.dist;

                if (distance[nextIndex] > distance[nowIndex] + nextDist) {
                    distance[nextIndex] = distance[nowIndex] + nextDist;
                    pq.add(next);
                }
            }
        }
    }
}