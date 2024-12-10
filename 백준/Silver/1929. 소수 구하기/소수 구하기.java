import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] isPrime = new boolean[N + 1];

        // 0과 1은 소수가 아님
        isPrime[0] = false;
        isPrime[1] = false;

        // 처음에는 모든 수를 소수로 가정
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 구현
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 결과 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
