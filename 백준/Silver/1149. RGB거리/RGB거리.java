import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }else{
                arr[i][0] = Integer.parseInt(st.nextToken()) + Math.min(arr[i - 1][1], arr[i - 1][2]);
                arr[i][1] = Integer.parseInt(st.nextToken()) + Math.min(arr[i - 1][0], arr[i - 1][2]);
                arr[i][2] = Integer.parseInt(st.nextToken()) + Math.min(arr[i - 1][0], arr[i - 1][1]);
            }
        }

        int answer = Math.min(arr[N - 1][0], Math.min(arr[N - 1][1], arr[N - 1][2]));

        System.out.println(answer);

    }
}