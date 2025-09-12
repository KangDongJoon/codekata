import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        int S6A = Integer.parseInt(A.replaceAll("5", "6"));
        int S5A = Integer.parseInt(A.replaceAll("6", "5"));
        int S6B = Integer.parseInt(B.replaceAll("5", "6"));
        int S5B = Integer.parseInt(B.replaceAll("6", "5"));

        int min = S5A + S5B;
        int max = S6A + S6B;

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
