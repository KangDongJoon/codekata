import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] graph; // 그래프
    static int[][] distance; // 거리계산
    static boolean[][] visited; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static int N; // 입력
    static int M; // 입력

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 변수 초기화
        graph = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];
        
        // 시작점 = 거리1
        distance[0][0] = 1;

        // 길 생성
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int n = input.charAt(j) - '0';
                graph[i][j] = n;
            }
        }

        // 프로그램 함수 동작
        BFS(0, 0);

        // 마지막 거리 출력
        System.out.println(distance[N - 1][M - 1]);
    }

    // 최단거리 프로그래밍
    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = {x, y};
        queue.add(arr);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                int[] nextPoint = {nextX, nextY};

                // 범위 벗어나는 경우 패스
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }

                // 길이 아닌 경우 패스
                if(graph[nextX][nextY] == 0){
                    continue;
                }

                // 방문한 경우 패스
                if(visited[nextX][nextY]){
                    continue;
                }

                // 갈수있는 길인 경우 큐에 추가하고 방문처리, 해당 지점의 거리는 이전 지점 +1
                queue.add(nextPoint);
                visited[nextX][nextY] = true;

                distance[nextX][nextY] = distance[now[0]][now[1]] + 1;
            }
        }
    }
}
