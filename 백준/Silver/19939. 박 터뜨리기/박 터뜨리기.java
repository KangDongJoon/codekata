import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 공의 개수
        int K = sc.nextInt(); // 바구니 개수

        int sum = K * (K + 1) / 2; // 1 + 2 + ... + K

        if (sum > N) {
            System.out.println(-1);
            return;
        }

        int remain = N - sum; // 남은 공 개수

        if (remain % K == 0) {
            System.out.println(K - 1);
        } else {
            System.out.println(K);
        }
    }
}
