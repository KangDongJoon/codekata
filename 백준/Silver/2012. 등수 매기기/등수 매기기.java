import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] expects = new int[N];
        for (int i = 0; i < N; i++) {
            expects[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(expects);

        long total = 0;
        for (int i = 0; i < N; i++) {
            // 배정 등수는 i+1
            total += Math.abs(expects[i] - (i + 1));
        }

        System.out.println(total);
    }
}
