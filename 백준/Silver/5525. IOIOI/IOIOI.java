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

        int i = 0;
        count = 0;
        int patternCount = 0;

        while (i < M - 1) {
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && i + 2 < M && S.charAt(i + 2) == 'I') {
                patternCount++;
                if (patternCount == N) {
                    count++;
                    patternCount--;  // 윈도우를 슬라이드하기 위해 앞의 한 패턴을 제거
                }
                i += 2;  // `OI`가 끝난 후 `I`에서 다시 시작
            } else {
                patternCount = 0;
                i++;
            }
        }
        System.out.println(count);
    }

}
