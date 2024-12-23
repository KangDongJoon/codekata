import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int start = 0;
        while (N > 1) {
            int n = (int) Math.pow(2, N) / 2; // 중간지점
            int ud = r >= n ? 2 : 0; // 중간지점보다 크면 ud 아래쪽
            r = ud > 0 ? r - n : r;

            int lr = c >= n ? 1 : 0; // 중간지점보다 크면 오른쪽
            c = lr > 0 ? c - n : c;

            // 기준으로 시작점 찾기
            start += (int) ((Math.pow(2, N) * Math.pow(2, N)) * ((double) (ud + lr) / 4));
            N--;
        }

        if (r == 1) {
            r++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = start; i < start + 4; i++) {
            list.add(i);
        }

        System.out.println(list.get(r + c));


    }
}
