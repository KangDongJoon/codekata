import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] point = new int[N];

        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = point.length - 1; i >= 1; i--) {
            int now = point[i];
            int pre = point[i - 1];

            if (pre >= now) {
                int minus = pre - now + 1;
                count += minus;
                point[i - 1] = pre - minus;
            }
        }

        System.out.println(count);
    }
}
