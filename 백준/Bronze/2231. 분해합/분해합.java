import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int start = Math.max(1, n - (int) (Math.log10(n) + 1) * 9);

        for (int i = start; i < n; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == n) {
                bw.write(Integer.toString(i));
                bw.flush();
                return;
            }
        }

        bw.write("0");
        bw.flush();
    }
}
