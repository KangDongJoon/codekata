import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 케이스만큼 반복
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 보유한 의상 수
            Map<String, Integer> clothes = new HashMap<>();
            int typeCount = 0;

            // 옷 입력 받기
            for (int j = 0; j < n; j++) {
                String[] cloth = br.readLine().split(" ");
                String types = cloth[1];


                // 옷의 종류가 존재하면 +1 아니면 새로 맵에 입력
                if (!clothes.containsKey(types)) {
                    clothes.put(types, 1);
                    typeCount++;
                } else {
                    clothes.put(types, clothes.get(types) + 1);
                }
            }

            int answer = 1;
            for(Map.Entry<String, Integer> entry : clothes.entrySet()){
                answer *= entry.getValue() + 1;
            }

            bw.write(Integer.toString(answer - 1));
            bw.newLine();
        }

        bw.flush();
    }
}