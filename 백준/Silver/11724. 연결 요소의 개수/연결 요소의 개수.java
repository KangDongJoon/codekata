import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] graph;
    static boolean[] visit;
    static StringTokenizer st;
    static int N;
    static int M;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        createGraph(M);

        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                BFS(i);
            }
        }

        System.out.println(count);
    }

    static void createGraph(int M) throws IOException {

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }
    }

    static void BFS(int start){

        count++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()){

            int now = queue.poll();

            for(int next = 1; next <= N; next++){
                if(graph[now][next] == 1 && !visit[next]){
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }


    }
}
