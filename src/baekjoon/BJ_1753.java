package Day07.BJ_1753_최단경로;
// 맞음
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
    static class info implements Comparable<info>{
        int node;
        int distance;

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static int V, E, K;
    static ArrayList<info> [] Map;
    static int [] Distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        Map = new ArrayList[V + 1];
        Distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            Map[i] = new ArrayList<>();
            Distance[i] = INF;
        }

        int u, v, w;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            Map[u].add(new info(v, w));
        }

        findShortestPath(K);

        for (int i = 1; i <= V; i++) {
            if (Distance[i] != INF) {
                bw.write(Distance[i] +  "\n");
            } else {
                bw.write("INF"  + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void findShortestPath(int start) {
        PriorityQueue<info> pq = new PriorityQueue<>();
        Distance[start] = 0;
        pq.add(new info(start, 0));

        while (pq.isEmpty() == false) {
            info now = pq.poll();

            if (now.distance > Distance[now.node]) {
                continue;
            }

            for (info next : Map[now.node]) {
                if (Distance[next.node] > Distance[now.node] + next.distance) {
                    Distance[next.node] = Distance[now.node] + next.distance;
                    pq.add(new info(next.node, Distance[next.node]));
                }
            }
        }
    }
}
