import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        char now = input.charAt(0) != '-' ? '+' : '-';

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-') {
                if (now == '+') {
                    answer += Integer.parseInt(sb.toString());
                    now = c;
                } else {
                    answer -= Integer.parseInt(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        if (now == '+') {
            answer += Integer.parseInt(sb.toString());
        } else {
            answer -= Integer.parseInt(sb.toString());
        }

        System.out.println(answer);
    }
}
