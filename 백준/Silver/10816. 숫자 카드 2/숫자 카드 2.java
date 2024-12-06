import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] cards = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            String card = cards[i];
            if(map.containsKey(card)){
                map.put(card, map.get(card) + 1);
            }else{
                map.put(card, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] searches = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String search : searches) {
            if(map.containsKey(search)){
                sb.append(map.get(search)).append(" ");
            }else{
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
