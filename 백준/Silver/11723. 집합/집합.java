import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int bitMask = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "add":
                    bitMask |= (1 << (Integer.parseInt(command[1]) - 1));
                    break;
                case "remove":
                    bitMask &= ~(1 << (Integer.parseInt(command[1]) - 1));
                    break;
                case "check":
                    if ((bitMask & (1 << (Integer.parseInt(command[1]) - 1))) != 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    bitMask ^= (1 << (Integer.parseInt(command[1]) - 1));
                    break;
                case "all":
                    bitMask = (1 << 21) - 1;
                    break;
                case "empty":
                    bitMask = 0;
                    break;
            }
        }
        bw.flush();
    }
}
