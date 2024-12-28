import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> input = new ArrayList<>();

        for (int i = 0; i < N + M; i++) {
            input.add(br.readLine());
        }

        Collections.sort(input);
        
        List<String> answer = new ArrayList<>();
        
        for(int j = 0; j < input.size() - 1; j++){
            if(input.get(j).equals(input.get(j + 1))){
                answer.add(input.get(j));
            }
        }
        
        Collections.sort(answer);
        
        bw.write(Integer.toString(answer.size()));
        bw.newLine();

        for (String s : answer) {
            bw.write(s);
            bw.newLine();
        }
        
        bw.flush();
    }
}
