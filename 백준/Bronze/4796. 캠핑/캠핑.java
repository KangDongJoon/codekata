import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L, P, V;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (true) {
            i++;
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0) {
                break;
            }

            int impos = P - L;
            int answer = 0;

            while (V >= L) {
                answer += L;
                V -= L;
                V -= impos;
            }

            if (V > 0) {
                answer += V;
            }
            
            sb.append("Case ").append(i).append(": ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}