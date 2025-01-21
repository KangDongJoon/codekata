import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for(int j = 0; j < M; j++){
            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
    }
}