import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] table;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        table = new int[101];
        visit = new int[101];

        // 사다리 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table[a] = b; // a에서 b로 이동
        }

        // 뱀 입력
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table[a] = b; // a에서 b로 이동
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 시작 칸 추가
        visit[1] = 0; // 시작 칸 이동 횟수 초기화

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 100번 칸에 도달한 경우
            if (now == 100) {
                return visit[100];
            }

            // 주사위를 굴려 이동
            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                // 100번 칸을 넘으면 무시
                if (next > 100) {
                    continue;
                }

                // 사다리나 뱀이 있는 경우 처리
                if (table[next] != 0) {
                    next = table[next];
                }

                // 아직 방문하지 않은 칸이라면
                if (visit[next] == 0) {
                    visit[next] = visit[now] + 1; // 이동 횟수 갱신
                    queue.add(next); // 다음 칸 큐에 추가
                }
            }
        }

        // 100번 칸에 도달하지 못한 경우
        return -1;
    }
}
