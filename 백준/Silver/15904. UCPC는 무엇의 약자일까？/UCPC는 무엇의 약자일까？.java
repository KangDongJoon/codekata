import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String target = "UCPC";
        int pos = -1;

        boolean ok = true;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            pos = s.indexOf(c, pos + 1);
            if (pos == -1) {
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
