import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        for (int j = 2; j < N; j++) {
            for (int k = 2; j * k <= N; k++) {
                list.set(j * k - 1, 0);
            }
        }

        for (Integer n : list) {
            if (n != 0 && n != 1 && n >= M) {
                bw.write(Integer.toString(n));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
