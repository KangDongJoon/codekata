import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int input = Integer.parseInt(br.readLine());

        int t = 0;
        int f = input / 5;
        int min = Integer.MAX_VALUE;
        while (f >= 0) {
            int n = input;
            n -= f * 5;
            t = n / 3;
            if (n % 3 == 0) {
                int sum = t + f;
                if (sum < min) {
                    min = sum;
                }
            }
            f--;
        }

        if(min == Integer.MAX_VALUE){
            min = -1;
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
