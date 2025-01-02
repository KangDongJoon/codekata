import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] apart;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int total = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // 변수 초기화
        N = Integer.parseInt(br.readLine());
        apart = new int[N][N];
        visit = new boolean[N][N];

        // 아파트 배열 생성
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = input.charAt(j) - '0';
            }
        }

        // 아파트 배열 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apart[i][j] != 0 && !visit[i][j]) {
                    divide(i, j); // 함수 실행
                }
            }
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        answer.append(total).append("\n");
        

        for (Integer integer : list) {
            answer.append(integer).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();

    }

    static void divide(int x, int y) {
        total++; // 함수 실행 시 토탈 카운트 증가

        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = {x, y};
        // 첫번째 값 추가 및 방문처리
        queue.add(arr);
        visit[x][y] = true;

        int count = 1; // 아파트 단지 내 세대 수 카운팅

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N){
                    continue;
                }

                if(apart[nextX][nextY] == 1 && !visit[nextX][nextY]){
                    visit[nextX][nextY] = true;
                    int[] nextArr = {nextX, nextY};
                    queue.add(nextArr);
                    count++;
                }
            }
        }

        // 카운트 리스트에 추가
        list.add(count);
    }
}
