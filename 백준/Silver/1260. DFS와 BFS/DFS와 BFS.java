import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, V;
    static int[][] graph; // 인접 행렬
    static boolean[] visited; // 방문 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        graph(); // 그래프, 방문 배열 초기화 함수 호출
        DFS(V); // DFS 실행
        sb.append("\n");
        visited = new boolean[N + 1]; // BFS 실행을 위한 방문 여부 초기화
        BFS(V); // BFS 실행

        bw.write(sb.toString());
        bw.flush();

    }

    static void DFS(int node) {
        visited[node] = true; // 노드 방문 표시
        sb.append(node).append(" "); // 현재 노드 출력

        // 다음 간선 탐색
        for (int next = 1; next <= N; next++) {
            if (graph[node][next] == 1 && !visited[next]) { // 간선이 연결되어있고 방문하지않았으면 재귀 호출
                DFS(next);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        // 큐가 비었을 때 까지 반복
        while (!queue.isEmpty()) {
            int node = queue.poll(); // 시작점 꺼내기
            sb.append(node).append(" ");

            // 다음 자식 노드 추가 작업
            for (int next = 1; next <= N; next++) {
                if (graph[node][next] == 1 && !visited[next]) { // 방문 여부 확인
                    queue.add(next); // 자식 노드 추가
                    visited[next] = true; // 방문처리
                }
            }
        }
    }

    // 그래프 그리기
    static void graph() throws IOException {
        graph = new int[N + 1][N + 1]; // 그래프 초기화
        visited = new boolean[N + 1]; // 방문 여부 초기화

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 설정
            graph[a][b] = graph[b][a] = 1;
        }
    }

}
