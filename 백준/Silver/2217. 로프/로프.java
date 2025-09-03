import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < N; j++) {
            int nowMax = Math.max(arr[j] * (N - j), arr[j]);
            if (max < nowMax) {
                max = nowMax;
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
