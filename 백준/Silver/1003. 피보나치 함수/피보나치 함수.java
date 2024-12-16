import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][0] = 0;
        arr[0][1] = 0;
        arr[1][1] = 1;

        for(int j = 2; j < 41; j++){
            arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
            arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
        }
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(arr[a][0]).append(" ").append(arr[a][1]);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
    }
}