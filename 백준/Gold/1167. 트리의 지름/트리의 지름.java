import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V;
    static List<Node>[] graph;
    static boolean[] visit;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        input();

        // 1. 임의의 점 (보통 1번 노드)에서 가장 먼 노드를 찾음
        BFS(1);

        // 2. 찾은 가장 먼 노드에서 다시 BFS 실행하여 트리의 지름 계산
        BFS(farthestNode);

        System.out.println(maxDist);
    }

    static void input() throws IOException {
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int l = Integer.parseInt(st.nextToken());
                if (l == -1) break;
                int d = Integer.parseInt(st.nextToken());
                graph[v].add(new Node(l, d));
                graph[l].add(new Node(v, d)); // 양방향 그래프
            }
        }
    }

    static void BFS(int start) {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[V + 1];
        int[] distance = new int[V + 1];

        q.add(new int[]{start, 0});
        visit[start] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int dist = now[1];

            for (Node next : graph[node]) {
                if (!visit[next.v]) {
                    visit[next.v] = true;
                    distance[next.v] = dist + next.dist;
                    q.add(new int[]{next.v, distance[next.v]});

                    // 최댓값 업데이트
                    if (distance[next.v] > maxDist) {
                        maxDist = distance[next.v];
                        farthestNode = next.v;
                    }
                }
            }
        }
    }

    static class Node {
        int v, dist;
        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}
