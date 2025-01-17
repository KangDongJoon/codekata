import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2 ? 1 : -1;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (!heap.isEmpty()) {
                    sb.append(heap.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                heap.add(a);
            }
        }
        System.out.println(sb);
    }
}