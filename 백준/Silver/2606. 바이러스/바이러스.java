import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        // 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 그래프 생성
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        BFS();
        
        System.out.println(answer);

    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int next = 1; next <= N; next++){

                if (graph[now][next] != 0 && !visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    answer++;
                }
            }
        }

    }
}
