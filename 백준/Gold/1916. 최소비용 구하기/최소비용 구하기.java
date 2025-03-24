import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int M;
    static List<Bus>[] bus;
    static int[] cost;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        input();
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(Dijkstra(s, e));
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new ArrayList[N + 1];
        cost = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            bus[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus[s].add(new Bus(e, cost));
        }
    }

    static int Dijkstra(int s, int e){
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[s] = 0;
        pq.add(new Bus(s, 0));

        while (!pq.isEmpty()) {
            Bus now = pq.poll();
            int nowe = now.e;
            int nowcost = now.cost;

            if(cost[nowe] < nowcost) continue;

            for (Bus nextBus : bus[nowe]) {
                int nexte = nextBus.e;
                int nextcost = nextBus.cost;

                if (cost[nowe] + nextcost < cost[nexte]) {
                    cost[nexte] = cost[nowe] + nextcost;
                    pq.add(new Bus(nexte, cost[nexte]));
                }
            }
        }

        return cost[e];
    }

    static class Bus {
        private int e;
        private int cost;

        public Bus(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
