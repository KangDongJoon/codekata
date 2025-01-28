import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, P;
    static HashMap<Integer, Integer> trueP;
    static List<int[]> partyList = new ArrayList<>();
    static int[] party;
    static int count = 0;
    static boolean[] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();

        if (P == 0) {
            bw.write(Integer.toString(M));
            bw.flush();
            return;
        }

        for (int i = 0; i < M; i++) {
            party(i);
        }

        BFS();

        for (int[] party : partyList) {
            search(party);
        }

        bw.write(Integer.toString(count));
        bw.flush();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[M];

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        if (P != 0) {
            trueP = new HashMap<>();
            for (int i = 0; i < P; i++) {
                trueP.put(Integer.parseInt(st.nextToken()), 0);
            }
        }
    }

    static void party(int index) throws IOException {
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        party = new int[p];
        boolean flag = false;

        for (int i = 0; i < p; i++) {
            party[i] = Integer.parseInt(st.nextToken());
            if (trueP.containsKey(party[i])) {
                flag = true;
            }
        }
        if (flag) {
            q.add(party);
            visit[index] = true;
        }
        partyList.add(party);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] nowParty = q.poll();
            for (int i : nowParty) {
                if (!trueP.containsKey(i)) {
                    trueP.put(i, 0);
                }
            }

            for (int i = 0; i < partyList.size(); i++) {
                if (!visit[i]) {
                    int[] nextParty = partyList.get(i);
                    for (int j = 0; j < nextParty.length; j++) {
                        if (trueP.containsKey(nextParty[j])) {
                            q.add(nextParty);
                            visit[i] = true;
                        }
                    }
                }
            }
        }
    }

    static void search(int[] party) {
        for (int i : party) {
            if (trueP.containsKey(i)) return;
        }

        count++;
    }
}