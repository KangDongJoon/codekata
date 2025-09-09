import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int answer = 0;
        if (N == 1 || N == 3) {
            answer = -1;
        } else {
            if (N % 5 == 0) {
                answer = N / 5;
            }

            if ((N % 5) % 2 != 0) {
                answer = ((N / 5) - 1) + (N - (((N / 5) - 1) * 5)) / 2;
            } else {
                answer = (N / 5) + ((N % 5) / 2);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
