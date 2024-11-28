import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length - 1; i++) {
            if (convert(input[0]) == 1) {
                if (convert(input[i]) + 1 != convert(input[i + 1])) {
                    System.out.println("mixed");
                    break;
                }
                if (i == 6) {
                    System.out.println("ascending");
                }
            } else if (convert(input[0]) == 8) {
                if (convert(input[i]) - 1 != convert(input[i + 1])) {
                    System.out.println("mixed");
                    break;
                }
                if (i == 6) {
                    System.out.println("descending");
                }
            } else {
                System.out.println("mixed");
                break;
            }
        }

//        bw.flush();
    }

    static int convert(String s) {
        return Integer.parseInt(s);
    }
}
