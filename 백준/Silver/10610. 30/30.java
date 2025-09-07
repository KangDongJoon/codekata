import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();

        if (!a.contains("0")) {
            System.out.println(-1);
            return;
        }

        char[] digits = a.toCharArray();

        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(digits);

        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}