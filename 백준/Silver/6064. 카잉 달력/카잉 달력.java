import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        test:
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int max = (M * N) / gcd(M, N);

            for(int i = x; i <= max; i += M){
                int j = i % N == 0 ? N : i % N;
                if(j == y){
                    answer.append(i + "\n");
                    continue test;
                }
            }
            answer.append(-1 + "\n");
        }
        System.out.print(answer);
    }

    static int gcd(int x, int y){
        if(y == 0) return x;

        return gcd(y, x % y);
    }
}