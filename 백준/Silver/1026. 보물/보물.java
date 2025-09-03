import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int[] arr = new int[N];
        for (int q = 0; q < N; q++) {
            int index = -1;
            int max = -1;
            for (int k = 0; k < N; k++) {
                int now = B[k];
                if (now > max && !check[k]) {
                    max = now;
                    index = k;
                }
            }
            arr[index] = A[q];
            check[index] = true;
        }

        int answer = 0;
        for (int w = 0; w < N; w++) {
            answer += (arr[w] * B[w]);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
