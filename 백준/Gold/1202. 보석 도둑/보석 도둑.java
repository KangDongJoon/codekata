import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
        // 무게 오름차순 정렬
        Arrays.sort(jewels, Comparator.comparingInt(a -> a[0]));

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 가방도 무게 오름차순
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int idx = 0;

        for (int bag : bags) {
            // 현재 가방에 넣을 수 있는 모든 보석을 후보군(pq)에 추가
            while (idx < N && jewels[idx][0] <= bag) {
                pq.add(jewels[idx][1]); // 가치만 저장
                idx++;
            }
            // 후보군 중 가장 가치 큰 것 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }
}
