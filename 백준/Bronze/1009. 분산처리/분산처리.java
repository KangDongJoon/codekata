import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            // 거듭제곱 계산 시 마지막 자리만 필요하므로 % 10
            for (int i = 0; i < b; i++) {
                result = (result * a) % 10;
            }

            // 마지막 결과가 0이면 10 출력
            if (result == 0) result = 10;

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
