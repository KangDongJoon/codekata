import java.io.*;
import java.math.BigInteger;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int L = Integer.parseInt(br.readLine());
        String read = br.readLine();

        BigInteger sum = BigInteger.valueOf(0);
        for(int i = 0; i < L; i++){
            int c = read.charAt(i) - 96;
            BigInteger num = BigInteger.valueOf(c).multiply(BigInteger.valueOf(31).pow(i));
            sum = sum.add(num);
        }
        sum = sum.mod(BigInteger.valueOf(1234567891));

        bw.write(sum.toString());
        bw.flush();

    }
}
