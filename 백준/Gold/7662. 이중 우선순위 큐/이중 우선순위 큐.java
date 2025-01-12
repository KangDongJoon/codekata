import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    int key;
                    if (num > 0) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }

                    if(map.get(key) - 1 == 0){
                        map.remove(key);
                    }else{
                        map.put(key, map.get(key) - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}