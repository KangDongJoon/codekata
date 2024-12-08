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

        for (int i = 1; i <= N; i++) {
            linkedList.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        int start = 0;
        while (!linkedList.isEmpty()) {
            index = (start + K - 1) % linkedList.size();
            sb.append(linkedList.get(index));
            linkedList.remove(index);
            if(!linkedList.isEmpty()){
                sb.append(", ");
            }
            start = index;
        }

        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}
