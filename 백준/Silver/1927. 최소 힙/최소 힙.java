import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                if (minHeap.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    int b = minHeap.remove();
                    bw.write(Integer.toString(b));
                    bw.newLine();
                }
            }else{
                minHeap.add(a);
            }
        }
        bw.flush();

    }
}
