import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][M];

        int packMin = Integer.MAX_VALUE;
        int oneMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            if (pack < packMin) {
                packMin = pack;
            }

            if (one < oneMin) {
                oneMin = one;
            }
        }

        int a = packMin * (N / 6) + oneMin * (N % 6);
        int b = packMin * ((N / 6) + 1);
        int c = oneMin * N;
        int answer = Math.min(a, Math.min(b, c));


        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
