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

        int a = 1000 - T;
        int[] change = {500, 100, 50, 10, 5, 1};
        int answer = 0;
        for (int i = 0; i < change.length; i++) {
            answer += a / change[i];
            a %= change[i];
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}