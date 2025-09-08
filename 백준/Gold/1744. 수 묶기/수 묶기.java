import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        boolean zero = false;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                plus.add(n);
            }
            if (n < 0) {
                minus.add(n);
            }
            if (n == 0) {
                zero = true;
            }
        }
        Collections.sort(minus);
        plus.sort(Collections.reverseOrder());
        if (minus.size() % 2 == 1 && zero) {
            minus.remove(minus.size() - 1);
        }

        int answer = 0;
        for (int i = 0; i < minus.size() - 1; i += 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }
        if (!minus.isEmpty() && minus.size() % 2 != 0) {
            answer += minus.get(minus.size() - 1);
        }

        for (int i = 0; i < plus.size() - 1; i += 2) {
            answer += Math.max(plus.get(i) * plus.get(i + 1), plus.get(i) + plus.get(i + 1));
        }
        if (!plus.isEmpty() && plus.size() % 2 != 0) {
            answer += plus.get(plus.size() - 1);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
