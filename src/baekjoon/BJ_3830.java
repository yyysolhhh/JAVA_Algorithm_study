package Day08.BJ_3830;
// 맞음
import java.io.*;
import java.util.StringTokenizer;

public class BJ_3830 {
    static int N, M;
    static int[] parent;
    static int[] weightDiff; // sol은 long으로 되어있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            weightDiff = new int[N + 1];
            parent = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            String q;
            int a, b, w;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                q = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (q.equals("!")) {
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else if (q.equals("?")) {
                    if (find(a) == find(b)) {
                        bw.write(weightDiff[b] - weightDiff[a] + "\n");
                    } else {
                        bw.write("UNKNOWN" + "\n");
                    }
                }
                bw.flush();
            }
        }
        bw.close();

    }

    static void union(int a, int b, int w) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return;
        }

        weightDiff[bRoot] = weightDiff[a] - weightDiff[b] + w; // += 로 해도 맞음
        parent[bRoot] = aRoot;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            int parentInx = find(parent[a]);
            weightDiff[a] += weightDiff[parent[a]];
            return parent[a] = parentInx;
        }
    }
}
