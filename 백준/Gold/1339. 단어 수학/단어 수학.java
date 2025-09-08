import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        // 알파벳 가중치 저장 (A~Z → 26개)
        int[] weight = new int[26];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int len = word.length();

            // 뒤에서부터 자리수 계산 (1, 10, 100, …)
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                int idx = c - 'A';
                weight[idx] += (int) Math.pow(10, len - j - 1);
            }
        }

        // 가중치 내림차순 정렬
        Integer[] arr = Arrays.stream(weight).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int num = 9;
        int answer = 0;
        for (int w : arr) {
            if (w == 0) break; // 더 이상 기여도가 없는 알파벳
            answer += w * num;
            num--;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
