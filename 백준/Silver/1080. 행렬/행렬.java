import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static List<int[][]> li;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        li = new ArrayList<>();
        int T = 0;
        while (T < 2) {
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = (int) s.charAt(j) - '0';
                }
            }
            li.add(arr);
            T++;
        }

        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (li.get(0)[i][j] != li.get(1)[i][j]) {
                    replace(i, j);
                    answer++;
                    if (Arrays.deepEquals(li.get(0), li.get(1))) {
                        break;
                    }
                }
            }
        }

        if (!Arrays.deepEquals(li.get(0), li.get(1))) {
            answer = -1;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static void replace(int n, int m) {
        for (int i = n; i < n + 3; i++) {
            for (int j = m; j < m + 3; j++) {
                if (li.get(0)[i][j] == 0) {
                    li.get(0)[i][j] = 1;
                } else {
                    li.get(0)[i][j] = 0;
                }
            }
        }
    }
}
