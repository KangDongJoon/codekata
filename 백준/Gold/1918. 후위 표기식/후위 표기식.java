import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        String order = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> operation = new Stack<>();

        for(int i = 0; i < order.length(); i++) {

            char c = order.charAt(i);

            if(Character.isAlphabetic(c)) {
                sb.append(order.charAt(i));
            }
            else {

                if(c == '(') {
                    operation.add(c);
                }
                else if(c == ')') {
                    while(!operation.isEmpty()) {
                        if(operation.peek() == '(') {
                            operation.pop();
                            break;
                        }
                        sb.append(operation.pop());
                    }
                }

                else if(c == '*' || c == '/') {
                    while(!operation.isEmpty()) {
                        if(operation.peek() == '(' || operation.peek() == ')') break;
                        if(operation.peek() == '+' || operation.peek() == '-') break;
                        if(operation.peek() == '*' || operation.peek() == '/') sb.append(operation.pop());
                    }
                    operation.add(c);
                }
                else if(c == '+' || c == '-') {
                    while(!operation.isEmpty()) {
                        if(operation.peek() == '(' || operation.peek() == ')') break;
                        sb.append(operation.pop());
                    }
                    operation.add(c);
                }
            }

        }

        while (!operation.isEmpty()) {
            sb.append(operation.pop());
        }

        System.out.println(sb);
    }

}
