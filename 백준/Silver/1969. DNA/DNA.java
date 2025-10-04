import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine().trim();
        }

        StringBuilder result = new StringBuilder();
        int totalHamming = 0;

        // 각 열마다 처리
        for (int j = 0; j < M; j++) {
            int countA = 0, countC = 0, countG = 0, countT = 0;
            for (int i = 0; i < N; i++) {
                char ch = dna[i].charAt(j);
                switch (ch) {
                    case 'A': countA++; break;
                    case 'C': countC++; break;
                    case 'G': countG++; break;
                    case 'T': countT++; break;
                }
            }
            // 최대 빈도 + 사전순 고려
            // 순서를 A, C, G, T 로 미리 정해두고 비교
            int maxCount = countA;
            char chosen = 'A';
            if (countC > maxCount || (countC == maxCount && 'C' < chosen)) {
                maxCount = countC;
                chosen = 'C';
            }
            if (countG > maxCount || (countG == maxCount && 'G' < chosen)) {
                maxCount = countG;
                chosen = 'G';
            }
            if (countT > maxCount || (countT == maxCount && 'T' < chosen)) {
                maxCount = countT;
                chosen = 'T';
            }

            result.append(chosen);
            totalHamming += (N - maxCount);
        }

        System.out.println(result.toString());
        System.out.println(totalHamming);
    }
}
