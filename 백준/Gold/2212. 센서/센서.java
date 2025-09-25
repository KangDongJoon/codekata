import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,K;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int[] sensor = new int[set.size()];

        int index = 0;
        for (Integer i : set) {
            sensor[index] = i;
            index++;
        }

        Arrays.sort(sensor);

        int[] diff = new int[sensor.length - 1];
        for (int i = 0; i < sensor.length - 1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < diff.length - (K - 1); i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}
