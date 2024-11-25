import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<String> list = new ArrayList<>();
    // 입력 pop
    // 출력 size, empty(1,0), top, pop(-1)

    public static void main(String[] args) throws IOException {

        Main boj = new Main();

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String[] read = br.readLine().split(" ");
            if (read[0].equals("push")) {
                list.add(read[1]);
            } else {
                boj.switchFun(read[0]);
                bw.newLine();
            }
        }
        bw.flush();
    }

    private void switchFun(String read) throws IOException {

        switch (read) {
            case "size": bw.write(String.valueOf(list.size()));
                break;

            case "top" : {
                if (list.size() == 0) {
                    bw.write("-1");
                } else {
                    bw.write(list.get(list.size() - 1));
                }
                break;
            }

            case "pop" : {
                if (list.size() == 0) {
                    bw.write("-1");
                } else {
                    bw.write(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
                break;
            }

            case "empty" : {
                if (list.size() == 0) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                break;
            }

        }
    }
}

