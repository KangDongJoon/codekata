import java.io.*;
import java.util.Stack;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String read;
        while (!(read = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < read.length(); i++) {
                char c = read.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        bw.write("no");
                        bw.newLine();
                        break;
                    } else {
                        if (!(c - stack.peek() == 1 || c - stack.peek() == 2)) {
                            bw.write("no");
                            bw.newLine();
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
                if(i == read.length() - 1){
                    bw.write(stack.isEmpty() ? "yes" : "no");
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }
}
