import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        // (A * B) % C == ( (A % C) * (B % C) ) % C
        long result = 1;

        while (B > 0) {
            if (B % 2 == 1) {
                result = (result * A) % C;
            }
            A = (A * A) % C;
            B /= 2;
        }

        System.out.println(result);
    }
}