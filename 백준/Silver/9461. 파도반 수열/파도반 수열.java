import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;

        for(int i = 5; i < 101; i++){
            arr[i] =  arr[i - 2] + arr[i - 3];
        }

        int T = Integer.parseInt(br.readLine());

        for(int j = 0; j < T; j++){
            bw.write(Long.toString(arr[Integer.parseInt(br.readLine())]));
            bw.newLine();
        }

        bw.flush();
    }
}