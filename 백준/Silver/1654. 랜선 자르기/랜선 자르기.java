import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // 입력 처리
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();
        long sum = 0;

        // 리스트에 값 추가 및 총합 계산
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
            sum += a;
        }

        // 이진 탐색을 사용한 평균값 탐색
        long left = 1;
        long right = sum / target;
        long result = 0;

        while (left <= right) {
            long avg = (left + right) / 2;
            long count = 0;

            // 현재 평균으로 분배 가능한 총합 계산
            for (Integer num : list) {
                count += num / avg;
            }

            if (count >= target) {
                result = avg;
                left = avg + 1;
            } else {
                right = avg - 1;
            }
        }

        System.out.println(result);
    }
}
