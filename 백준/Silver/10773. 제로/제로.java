import java.io.*;
import java.util.Stack;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            String read = br.readLine();
            if(read.equals("0")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(read));
            }
        }

        int sum = 0;
        for (Integer i : stack) {
            sum += i;
        }

        System.out.println(sum);
    }
}
