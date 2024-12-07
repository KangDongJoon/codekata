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

        int answer = factorial(N) / (factorial(K) * factorial(R));

        System.out.println(answer);

    }

    static int factorial(int a){
        
        int fac = 1;
        for(int i = 2; i <= a; i++){
            fac *= i;
        }

        return fac;
    }
}
