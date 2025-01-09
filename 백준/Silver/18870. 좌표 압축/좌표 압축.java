import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new TreeSet<>(Arrays.asList(arr));
        Integer[] sortArr = set.toArray((new Integer[0]));

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sortArr.length; i++) {
            indexMap.put(sortArr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) {
            arr[j] = indexMap.get(arr[j]);
            sb.append(arr[j] + " ");
        }

        System.out.println(sb.toString());

    }
}