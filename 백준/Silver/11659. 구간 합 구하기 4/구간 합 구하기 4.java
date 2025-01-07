import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = arr[end] - arr[start - 1];

            bw.write(Integer.toString(sum));
            bw.newLine();;
        }

        bw.flush();
    }
}
