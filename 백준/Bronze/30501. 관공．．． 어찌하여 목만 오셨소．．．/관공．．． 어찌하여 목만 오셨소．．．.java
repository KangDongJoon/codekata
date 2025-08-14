import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (name.contains("S")) {
                answer = name;
                break;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}