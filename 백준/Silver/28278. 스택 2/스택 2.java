import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 2) {
                st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                push(n);
            } else {
                int command = Integer.parseInt(st.nextToken());
                switch (command) {
                    case 2:
                        sb.append(pop()).append("\n");
                        break;
                    case 3:
                        sb.append(count()).append("\n");
                        break;
                    case 4:
                        sb.append(empty()).append("\n");
                        break;
                    case 5:
                        sb.append(get()).append("\n");
                        break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void push(int n) {
        stack.add(n);
    }

    static int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int lastIndexOf = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return lastIndexOf;
        }

    }

    static int count() {
        return stack.size();
    }

    static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    static int get() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

}