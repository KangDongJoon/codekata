import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        List<int[]> graph = new ArrayList<>(); // 최상위 꼭지점 입
        graph.add(new int[]{Integer.parseInt(br.readLine())});

        if (n == 1) {
            System.out.println(graph.get(0)[0]);
            return;
        }

        // n > 1일때 입력받아 삼각형 만들기
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                int[] arr = new int[i];
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                graph.add(arr);
            }
        }

        List<int[]> answer = new ArrayList<>();
        answer.add(graph.get(0));

        if (n > 1) {
            int[] second = new int[2];
            second[0] = answer.get(0)[0] + graph.get(1)[0];
            second[1] = answer.get(0)[0] + graph.get(1)[1];
            answer.add(second);

            for (int i = 3; i <= n; i++) {
                int[] arr = new int[i];

                for (int j = 0; j < arr.length; j++) {
                    if (j == 0) {
                        arr[j] = graph.get(i - 1)[0] + answer.get(i - 2)[0];
                    } else if (j == arr.length - 1) {
                        arr[j] = graph.get(i - 1)[arr.length - 1] + answer.get(i - 2)[arr.length - 2];
                    } else {
                        int a = Math.max(answer.get(i - 2)[j], answer.get(i - 2)[j - 1]);
                        arr[j] = graph.get(i - 1)[j] + a;
                    }
                }
                answer.add(arr);
            }

            int ans = 0;
            for (int i : answer.get(answer.size() - 1)) {
                if (i > ans) {
                    ans = i;
                }
            }

            System.out.println(ans);
        }
    }
}
