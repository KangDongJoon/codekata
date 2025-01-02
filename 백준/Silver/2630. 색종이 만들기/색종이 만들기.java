import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {

        // 입력
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        white = 0;
        blue = 0;

        // 색종이 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void search(int row, int col, int size) {

        if (size < 1) {
            return;
        }

        if (check(row, col, size)) {
            if (paper[col][row] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        // 재귀 호출
        int newSize = size / 2;
        // 1사분면
        search(row + newSize, col, newSize);
        // 2사분면
        search(row, col, newSize);
        // 3사분면
        search(row, col + newSize, newSize);
        // 4사분면
        search(row + newSize, col + newSize, newSize);

    }

    static boolean check(int row, int col, int size) {

        int color = paper[col][row];

        for (int i = col; i < col + size; i++) {
            for (int j = row; j < row + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
