import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String read;
        while (!(read = br.readLine()).equals("0")) {
            int l = 0;
            int r = read.length() - 1;
            while (l < read.length() / 2) {
                if (read.charAt(l) != read.charAt(r)) {
                    bw.write("no");
                    bw.newLine();
                    break;
                }
                l++;
                r--;
            }
            if (l == read.length() / 2) {
                bw.write("yes");
                bw.newLine();
            }
        }
        bw.flush();
    }
}
