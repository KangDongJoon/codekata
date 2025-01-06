import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static String S;
    static boolean flag;
    static int count;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        count = 0;

        StringBuilder target = new StringBuilder();

        target.append("I");
        for (int i = 0; i < N; i++) {
            target.append("OI");
        }



        int j = 0;
        while (j < M) {
            char first = S.charAt(j);

            if (first == 'I') {
                StringBuilder sb = new StringBuilder();
                sb.append(first);
                flag = false;

                for (int i = j + 1; i < M; i++) {
                    char next = S.charAt(i);

                    if (!flag) {
                        if (next == 'O') {
                            sb.append(next);
                            flag = !flag;
                        } else {
                            break;
                        }
                    } else {
                        if (next == 'I') {
                            sb.append(next);
                            flag = !flag;
                        } else{
                            break;
                        }
                    }

                    if(sb.toString().equals(target.toString())){
                        count++;
                        break;
                    }
                }
            }

            j++;

        }
        System.out.println(count);
    }
}
