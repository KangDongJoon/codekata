import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String S;

    public static void main(String[] args) throws IOException {
        S = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'A']++;
        }
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                left.append((char) (i + 'A'));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if (oddCount == 1) {
            System.out.println(left.toString() + oddChar + right.toString());
        } else {
            System.out.println(left.toString() + right.toString());
        }

        bw.flush();
        bw.close();
    }
}
