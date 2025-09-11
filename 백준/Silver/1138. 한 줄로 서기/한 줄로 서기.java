import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> li = new ArrayList<>();

        for (int i = N - 1; i >= 0; i--) {
            li.add(arr[i], i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : li) {
            sb.append(i).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
