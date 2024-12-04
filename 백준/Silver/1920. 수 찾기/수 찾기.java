import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<Integer> setN = new HashSet<>();
        for (String num : br.readLine().split(" ")) {
            setN.add(Integer.parseInt(num));
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrM = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int num : arrM) {
            if (setN.contains(num)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
