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

        bw.write(Integer.toString(total));
        bw.newLine();

        for (Integer integer : list) {
            bw.write(Integer.toString(integer));
            bw.newLine();
        }

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

                if (nextX >= 0 && nextX < N && !visit[nextX][now[1]]) {
                    if (apart[nextX][now[1]] == 1) {
                        visit[nextX][now[1]] = true;
                        int[] nextXarr = {nextX, now[1]};
                        queue.add(nextXarr);
                        count++;
                        continue;
                    }

                }

                if (nextY >= 0 && nextY < N && !visit[now[0]][nextY]) {
                    if (apart[now[0]][nextY] == 1) {
                        visit[now[0]][nextY] = true;
                        int[] nextYarr = {now[0], nextY};
                        queue.add(nextYarr);
                        count++;
                    }
                }
            }
        }

        list.add(count);
    }
}
