import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] reads = br.readLine().split(" ");
        int N = Integer.parseInt(reads[0]);
        int K = Integer.parseInt(reads[1]);

        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            linkedList.add(i);
        }

        int index = 0;
        int start = 0;
        while (!linkedList.isEmpty()) {
            index = (start + K - 1) % linkedList.size();
            list.add(linkedList.get(index));
            linkedList.remove(index);
            start = index;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        for (Integer s : list) {
            sb.append(s).append(", ");
        }
        String answer = sb.toString().substring(0, sb.length() - 2) + ">";
        
        bw.write(answer);
        bw.flush();
    }
}
