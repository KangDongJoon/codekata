import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[2]);

            int X = N % H == 0 ? N / H : (N / H) + 1;
            int Y = N % H == 0 ? H : N % H;
            StringBuilder sb = new StringBuilder();
            if (X < 10) {
                sb.append(Y).append(0).append(X);
            } else {
                sb.append(Y).append(X);
            }

            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
    }
}
