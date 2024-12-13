import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String answer = "";

        if(Character.isDigit(a.charAt(0))){
            int ans = Integer.parseInt(a) + 3;
            answer = FizzBuzz(Integer.toString(ans));
        }

        if(Character.isDigit(b.charAt(0))){
            int ans = Integer.parseInt(b) + 2;
            answer = FizzBuzz(Integer.toString(ans));
        }

        if(Character.isDigit(c.charAt(0))){
            int ans = Integer.parseInt(c) + 1;
            answer = FizzBuzz(Integer.toString(ans));
        }

        System.out.println(answer);
    }

    static String FizzBuzz(String a) {
        int n = Integer.parseInt(a);

        if (n % 15 == 0) {
            return "FizzBuzz";
        }

        if (n % 3 == 0) {
            return "Fizz";
        }

        if (n % 5 == 0) {
            return "Buzz";
        }

        return a;
    }
}
