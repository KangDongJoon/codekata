import java.io.*;
import java.util.HashMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 입력 크기
        String[] tanghulu = br.readLine().split(" "); // 탕후루 배열

        int l = 0; // 왼쪽 포인터
        int r = 0; // 오른쪽 포인터
        int max = 0; // 최댓값
        HashMap<Integer, Integer> map = new HashMap<>(); // 구간 내 숫자 빈도 관리

        while (r < N) {
            int current = Integer.parseInt(tanghulu[r]);
            map.put(current, map.getOrDefault(current, 0) + 1); // 현재 숫자 추가

            // 구간 내 서로 다른 숫자가 2개를 초과하면 왼쪽 포인터 이동
            while (map.size() > 2) {
                int leftValue = Integer.parseInt(tanghulu[l]);
                map.put(leftValue, map.get(leftValue) - 1);

                // 빈도가 0이 되면 맵에서 제거
                if (map.get(leftValue) == 0) {
                    map.remove(leftValue);
                }
                l++; // 왼쪽 포인터 이동
            }

            // 현재 구간 길이를 계산하고 최댓값 갱신
            max = Math.max(max, r - l + 1);
            r++; // 오른쪽 포인터 이동
        }

        System.out.println(max); // 결과 출력
    }
}
