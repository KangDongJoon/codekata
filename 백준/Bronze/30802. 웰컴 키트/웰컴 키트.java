import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String[] shirts = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");

        int T = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        int tCount = 0;
        int pSetCount = n / P;
        int pSingleCount = n % P;
        StringBuilder sb = new StringBuilder();
        for (String shirt : shirts) {
            int a = Integer.parseInt(shirt);
            tCount += a % T == 0 ? a / T : a / T + 1;
        }

        sb.append(tCount).append("\n").append(pSetCount).append(" ").append(pSingleCount);
        bw.write(sb.toString());
        bw.flush();
    }
}
