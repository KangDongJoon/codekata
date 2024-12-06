import java.io.*;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0 0 0")) {
            String[] read = line.split(" ");
            int[] intArr = Arrays.stream(read).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(intArr);
            double pythagoras = Math.pow(intArr[0], 2) + Math.pow(intArr[1], 2);
            double third = Math.pow(intArr[2], 2);

            sb.append(pythagoras == third ? "right\n" : "wrong\n");

        }

        System.out.println(sb);
    }
}
