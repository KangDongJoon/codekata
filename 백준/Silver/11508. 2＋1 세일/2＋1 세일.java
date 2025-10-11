import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            prices.add(sc.nextInt());
        }
        // 내림차순 정렬
        prices.sort(Comparator.reverseOrder());

        long total = 0;
        for (int i = 0; i < N; i++) {
            // i % 3 == 2 이면 그 아이템은 무료 → 더하지 않음
            if (i % 3 != 2) {
                total += prices.get(i);
            }
        }

        System.out.println(total);
        sc.close();
    }
}
