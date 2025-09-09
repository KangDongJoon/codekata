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

        int packMin = Integer.MAX_VALUE;
        int oneMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packMin = Math.min(packMin, Integer.parseInt(st.nextToken()));
            oneMin = Math.min(oneMin, Integer.parseInt(st.nextToken()));
        }

        int answer = Math.min(
                Math.min(packMin * (N / 6) + oneMin * (N % 6), packMin * ((N / 6) + 1)),
                oneMin * N
        );


        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
