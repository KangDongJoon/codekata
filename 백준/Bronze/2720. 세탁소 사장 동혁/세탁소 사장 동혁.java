import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[] arr = {25, 10, 5, 1};
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(br.readLine());
            int[] change = new int[4];

            for (int j = 0; j < arr.length; j++) {
                int a = C / arr[j];
                C %= arr[j];
                change[j] = (int)a;
            }

            for (int i1 : change) {
                sb.append(i1).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
