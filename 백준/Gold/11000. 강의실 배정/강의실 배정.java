import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Class[] arr = new Class[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Class(s, e);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start == b.start) return a.end - b.end;
            return a.start - b.start;
        });

        pq.add(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (arr[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i].end);
        }

        int answer = pq.size();

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static class Class {
        private final int start;
        private final int end;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
