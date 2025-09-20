import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 후보 수
        int dasom = sc.nextInt(); // 다솜이 표

        if (n == 1) { // 후보가 다솜이 혼자일 경우
            System.out.println(0);
            return;
        }

        // 다른 후보들 표
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int max = pq.poll();
            max--;        // 표 1개 빼앗음
            dasom++;      // 다솜이에게 줌
            count++;
            pq.add(max);  // 갱신된 값 다시 넣기
        }

        System.out.println(count);
    }
}
