import java.io.*;
import java.math.BigInteger;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int size = Math.max(n + 1, 3);
        BigInteger[] arr = new BigInteger[size];
        arr[1] = BigInteger.valueOf(1);
        arr[2] = BigInteger.valueOf(2);

        for(int i = 3; i < n + 1; i++){
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }

        int answer = arr[n].mod(BigInteger.valueOf(10007)).intValue();

        System.out.println(answer);
    }
}
