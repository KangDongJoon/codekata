import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int TC;
    static int N;
    static int M;
    static int W;
    static List<Node> space;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            input();
            createSpace();
            bw.write(BellmanFord() ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
    }

    static void createSpace() throws IOException {
        space = new ArrayList<>();

        // 도로 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            space.add(new Node(s, e, d));
            space.add(new Node(e, s, d)); // 양방향
        }

        // 웜홀 (단방향)
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = -(Integer.parseInt(st.nextToken())); // 음수 간선
            space.add(new Node(s, e, d)); // 단방향
        }
    }

    static boolean BellmanFord() {
        distance = new int[N + 1];
        Arrays.fill(distance, 0); // 모든 노드에서 음수 사이클 체크 가능하도록 초기화

        // **N-1번 반복하여 최단 거리 갱신**
        for (int i = 0; i < N - 1; i++) {
            for (Node node : space) {
                if (distance[node.s] + node.d < distance[node.e]) {
                    distance[node.e] = distance[node.s] + node.d;
                }
            }
        }

        // **음수 사이클 판별 (한 번 더 갱신이 발생하면 YES)**
        for (Node node : space) {
            if (distance[node.s] + node.d < distance[node.e]) {
                return true; // 음수 사이클 존재
            }
        }

        return false; // 음수 사이클 없음
    }

    static class Node {
        int s, e, d;
        public Node(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
