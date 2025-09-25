import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 스크린 크기
        int M = Integer.parseInt(st.nextToken()); // 바구니 크기
        int J = Integer.parseInt(br.readLine()); // 사과 개수

        int left = 1;          // 바구니의 왼쪽 끝
        int right = M;         // 바구니의 오른쪽 끝
        int result = 0;        // 이동 거리 총합

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) {  // 사과가 왼쪽 바깥에서 떨어짐
                int move = left - apple;
                result += move;
                left -= move;
                right -= move;
            } else if (apple > right) { // 사과가 오른쪽 바깥에서 떨어짐
                int move = apple - right;
                result += move;
                left += move;
                right += move;
            }
            // 사과가 바구니 범위 안에 있으면 이동할 필요 없음
        }

        System.out.println(result);
    }
}
