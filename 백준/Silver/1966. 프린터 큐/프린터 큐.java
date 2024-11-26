import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //6 0
    //1 1 9 1 1 1
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            int target = Integer.parseInt(first[1]);

            LinkedList<Integer> list = Arrays.stream(second)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));


            int j = 0;

            while (!list.isEmpty()) {
                for (int k = 0; k < list.size(); k++) {
                    int now = list.get(0);
                    if (now < list.get(k)) {
                        list.addLast(now);
                        list.removeFirst();
                        if (target == 0) {
                            target = list.size() - 1;
                        } else {
                            target--;
                        }
                        break;
                    }
                    if (k == list.size() - 1) {
                        if (target == 0) {
                            bw.write(Integer.toString(j + 1));
                            bw.newLine();
                        }
                        list.removeFirst();
                        target--;
                        j++;
                    }
                }
            }
        }
        bw.flush();
    }
}
