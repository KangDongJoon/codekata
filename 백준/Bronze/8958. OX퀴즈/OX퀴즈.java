import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int point = 0;
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                point += count;
            }
            bw.write(Integer.toString(point));

            bw.newLine();
        }
        bw.flush();
    }
}
