package Day06.BJ_2252;
// 맞음
import java.io.*;
import java.util.*;

public class BJ_2252 {
    static int N,  M;
    static List<List<Integer>> graph;
    static int[] edge;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int A, B;
        edge = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            edge[B]++;
        }

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int stdNo = queue.poll();
            bw.write(stdNo + " ");
            List<Integer> list = graph.get(stdNo);
            for (int temp : list) {
                edge[temp]--;
                if (edge[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
