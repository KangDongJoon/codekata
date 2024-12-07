import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Queue<String> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String read = br.readLine();
            queue(read);
        }

        System.out.println(sb);
    }

    static void queue(String read) {
        String num = null;
        if (read.length() >= 5 && read.startsWith("push")) {
            num = read.substring(5);
            read = "push";
        }

        switch (read) {
            case "push":
                if (num != null) {
                    queue.add(num);
                }
                break;
            case "pop":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                    queue.remove();
                }
                break;
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            case "empty":
                if (queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                break;
            case "front":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
                break;
            case "back":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    String last = ((LinkedList<String>) queue).getLast();
                    sb.append(last).append("\n");
                }
                break;
        }
    }
}
