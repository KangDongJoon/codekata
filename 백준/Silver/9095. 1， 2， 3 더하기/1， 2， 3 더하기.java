import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;


        for(int j = 4; j < 12; j++){
            arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
        }

        for(int i = 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(arr[target]));
            bw.newLine();
        }

        bw.flush();
    }
}
