import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        int count = 0;

        while (B > A) {
            if (B % 10 == 1) {
                B /= 10;
                count++;
            } else if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        if (B == A) {
            System.out.println(count + 1);  // A에서 B로 바꾸는 총 연산 횟수
        } else {
            System.out.println(-1);
        }
    }
}
