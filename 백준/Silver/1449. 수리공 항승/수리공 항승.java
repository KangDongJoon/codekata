import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static double L;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Double.parseDouble(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(arr[0] + 0.5);
        double tape = L - 1;

        for (int i = 1; i < N; i++) {
            double nowEnd = pq.peek();
            double nextStart = arr[i] - 0.5;
            double need = nextStart - nowEnd + 1;

            if (tape >= need) {
                tape -= need;
                pq.poll();
                pq.add(nextStart + 1);
            } else {
                tape = L - 1;
                pq.add(nextStart + 1);
            }
        }

        bw.write(Integer.toString(pq.size()));
        bw.flush();
        bw.close();
    }
}
