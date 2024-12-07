import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int R = N - K;
        // N! / K!(N-K)!

        if((N == K) || (K == 0)){
            bw.write("1");
            bw.flush();
            return;
        }

        int answer = factorial(N) / (factorial(K) * factorial(R));

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static int factorial(int a){

        int fac = 1;
        for(int i = 2; i <= a; i++){
            fac *= i;
        }

        return fac;
    }
}
