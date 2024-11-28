import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        // Number
        int x = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
        bw.write(Integer.toString(x));
        bw.newLine();
        // String
        int y = Integer.parseInt(A + B) - Integer.parseInt(C);
        bw.write(Integer.toString(y));

        bw.flush();
    }
}
