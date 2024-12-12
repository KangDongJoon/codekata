import java.io.*;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        Arrays.sort(arr);

        for (int num : arr) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }

        bw.flush();

    }
}
