import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 입력
    static int[] stair;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        stair = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        if (N >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }
        
        System.out.println(dp[N]);
    }
}
