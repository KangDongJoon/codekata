import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, X;
    static List<Node>[] nomalGraph;
    static List<Node>[] reverseGraph;
    static int[] goDist;
    static int[] comebackDist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        input();

        dijkstra(X, goDist, reverseGraph);
        dijkstra(X, comebackDist, nomalGraph);

        int answer = 0;
        for(int i = 0; i < N + 1; i++){
            answer = Math.max(goDist[i] + comebackDist[i], answer);
        }

        System.out.println(answer);
    }

    static void input() throws IOException {
        nomalGraph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            nomalGraph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        goDist = new int[N + 1];
        Arrays.fill(goDist, Integer.MAX_VALUE);
        comebackDist = new int[N + 1];
        Arrays.fill(comebackDist, Integer.MAX_VALUE);
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nomalGraph[s].add(new Node(e, d));
            reverseGraph[e].add(new Node(s, d));
        }
    }

    static void dijkstra(int start, int[] arr, List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Node(start, 0));
        arr[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nowIndex = now.node;
            int dist = now.dist;
            if(arr[nowIndex] < dist) continue;

            for(int i = 0; i < graph[nowIndex].size(); i++){
                Node next = graph[nowIndex].get(i);
                int nextIndex = next.node;
                int nextDist = next.dist;

                if(arr[nextIndex] > arr[nowIndex] + nextDist){
                    arr[nextIndex] = arr[nowIndex] + nextDist;
                    pq.add(next);
                }
            }
        }

    }

    static class Node {
        private int node;
        private int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}