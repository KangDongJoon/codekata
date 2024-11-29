import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        List<List<String>> lengthList = new ArrayList<>();

        for (int i = 0; i < 51; i++) {
            lengthList.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            String read = br.readLine();
            if (!lengthList.get(read.length()).contains(read)) {
                lengthList.get(read.length()).add(read);
            }
        }

        for (List<String> list : lengthList) {
            if (!list.isEmpty()) {
                Collections.sort(list);
                for (String s : list) {
                    bw.write(s);
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }
}
