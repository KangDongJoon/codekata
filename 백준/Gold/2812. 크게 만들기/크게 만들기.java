import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static String n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        n = br.readLine();
        Deque<Character> stack = new LinkedList<>();
        int removeCount = K;

        for (int i = 0; i < N; i++) {
            char c = n.charAt(i);

            while (!stack.isEmpty() && removeCount > 0 && stack.peekLast() < c) {
                stack.pollLast();
                removeCount--;
            }
            stack.addLast(c);
        }

        while (removeCount > 0) {
            stack.pollLast();
            removeCount--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
