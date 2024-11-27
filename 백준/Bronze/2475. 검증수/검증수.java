import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int sum = 0;

        for (String s : input) {
            double n = Math.pow(Integer.parseInt(s), 2);
            sum += n;
        }
        
        int answer = sum % 10;
        
        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
