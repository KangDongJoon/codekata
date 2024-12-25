import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] relation; // 인접 행렬

    public static void main(String[] args) throws IOException {
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new int[N + 1][N + 1];

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = relation[b][a] = 1; // 양방향 연결
        }

        // 최소 베이컨 수 계산
        int answer = 0;
        int minBacon = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bacon = bfs(i); // BFS로 각 노드의 베이컨 수 계산
            if (bacon < minBacon) {
                minBacon = bacon;
                answer = i;
            } else if (bacon == minBacon && i < answer) {
                answer = i;
            }
        }

        System.out.println(answer);
    }

    // BFS로 특정 노드의 베이컨 수 계산
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.add(start);
        visited[start] = true;

        int bacon = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (relation[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    distance[i] = distance[current] + 1;
                    bacon += distance[i]; // 베이컨 수 누적
                }
            }
        }

        return bacon;
    }
}
