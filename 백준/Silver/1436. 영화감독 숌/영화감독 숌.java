import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        int start = 666;

        while (answer != n) {
            start++;
            if(Integer.toString(start).contains("666")){
                answer++;
            }
        }
        System.out.println(start);
    }
}
