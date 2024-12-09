import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][14];

            for (int j = 1; j < 15; j++) {
                arr[0][j - 1] = j;
            }

            for (int a = 1; a <= n; a++) {
                int sum = 0;
                for (int b = 0; b < 14; b++) {
                    sum += arr[a - 1][b];
                    arr[a][b] = sum;
                }
            }
            int answer = arr[n][k - 1];
            bw.write(Integer.toString(answer));
            bw.newLine();
        }
        bw.flush();
    }
}
