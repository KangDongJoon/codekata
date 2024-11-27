import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] arr =  new int[10];
        String multiple = String.valueOf(A * B * C);

        for(int i = 0; i < multiple.length(); i++){
            char c = multiple.charAt(i);
            int n = c - '0';
            arr[n]++;
        }

        for (int i : arr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
    }
}
