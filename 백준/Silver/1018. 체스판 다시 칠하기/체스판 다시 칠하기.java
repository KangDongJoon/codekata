import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] arr = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                sb = new StringBuilder();
                int line = 0;
                while (line < 8) {
                    sb.append(arr[j + line], i, i + 8);
                    line++;
                }
                int count1 = startB(sb);
                int count2 = startW(sb);
                if (min > Math.min(count1, count2)) {
                    min = Math.min(count1, count2);
                }
            }
        }
        System.out.println(min);
    }

    private static int startB(StringBuilder sb) {

        int count1 = 0;
        for (int i = 1; i <= 8; i++) {
            if (i % 2 == 1) {
                for (int j = (i - 1) * 8; j < i * 8; j += 2) {
                    if (sb.charAt(j) != 'B') {
                        count1++;
                    }
                    if (sb.charAt(j + 1) != 'W') {
                        count1++;
                    }
                }
            } else {
                for (int j = (i - 1) * 8; j < i * 8; j += 2) {
                    if (sb.charAt(j) != 'W') {
                        count1++;
                    }
                    if (sb.charAt(j + 1) != 'B') {
                        count1++;
                    }
                }
            }
        }
        return count1;
    }

    private static int startW(StringBuilder sb) {

        int count1 = 0;
        for (int i = 1; i <= 8; i++) {
            if (i % 2 == 1) {
                for (int j = (i - 1) * 8; j < i * 8; j += 2) {
                    if (sb.charAt(j) != 'W') {
                        count1++;
                    }
                    if (sb.charAt(j + 1) != 'B') {
                        count1++;
                    }
                }
            } else {
                for (int j = (i - 1) * 8; j < i * 8; j += 2) {
                    if (sb.charAt(j) != 'B') {
                        count1++;
                    }
                    if (sb.charAt(j + 1) != 'W') {
                        count1++;
                    }
                }
            }
        }
        return count1;
    }
}
