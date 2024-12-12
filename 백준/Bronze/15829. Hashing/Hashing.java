import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int L = Integer.parseInt(br.readLine());
        String read = br.readLine();

        int sum = 0;
        for(int i = 0; i < L; i++){
            sum += (int) ((read.charAt(i) - 96) * Math.pow(31, i));
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
