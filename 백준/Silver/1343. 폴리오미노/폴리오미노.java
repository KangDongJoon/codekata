import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String S;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        String A = "AAAA";
        String B = "BB";

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'X') {
                count++;
                if (count == 4) {
                    sb.append(A);
                    count = 0;
                }
            } else {
                if (count == 2) {
                    sb.append(B);
                    count = 0;
                }

                if (count % 2 == 1) {
                    sb = new StringBuilder();
                    sb.append(-1);
                    break;
                }

                sb.append(c);
            }
        }
        if (count == 2) {
            sb.append(B);
        }

        if (count % 2 == 1) {
            sb = new StringBuilder();
            sb.append(-1);
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
