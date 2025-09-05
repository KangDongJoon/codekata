import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int[] answer = new int[3];
        int[] button = {300, 60, 10};

        for (int i = 0; i < 3; i++) {
            int count = T / button[i];
            T %= button[i];
            answer[i] = count;
        }

        if (T != 0) {
            sb.append(-1);
        } else {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}