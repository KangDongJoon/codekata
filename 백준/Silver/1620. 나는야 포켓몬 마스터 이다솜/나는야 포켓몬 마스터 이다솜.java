import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> intMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        // 도감 등록
        for(int i = 1; i <= N; i++){
            String poke = br.readLine();
            intMap.put(i, poke);
            stringMap.put(poke, i);
        }

        // 문제
        for(int i = 0; i < M; i++){
            String question = br.readLine();
            if(Character.isDigit(question.charAt(0))){
                String answer = intMap.get(Integer.parseInt(question));
                bw.write(answer);
                bw.newLine();
            }else{
                String answer = Integer.toString(stringMap.get(question));
                bw.write(answer);
                bw.newLine();
            }
        }
        bw.flush();
    }
}
