import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String S, T;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        T = br.readLine();
        sb = new StringBuilder();
        sb.append(T);
        while (S.length() < sb.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                deleteA();
            } else {
                deleteB();
            }
        }

        if (sb.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void deleteA() {
        sb.deleteCharAt(sb.length() - 1);
    }

    static void deleteB() {
        sb.deleteCharAt(sb.length() - 1).reverse();
    }
}
