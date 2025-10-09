import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] t = new int[N];
        for (int i = 0; i < N; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(t);
        int maxDay = 0;
        for (int i = N - 1; i >= 0; i--) {
            maxDay = Math.max(maxDay, t[i] + (N - i));
        }
        System.out.println(maxDay + 1);
    }
}
