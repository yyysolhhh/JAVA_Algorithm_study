package Day06.BJ_1717;
// 맞음
import java.io.*;
import java.util.StringTokenizer;

public class BJ_1717 {
    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        initialize();
//        for (int j = 0; j <= n; j++) {
//            parent[j] = j;
//        }

        int op, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else if (op == 1) {
                if (find(a) == find(b)) {
                    bw.write("YES" + "\n");
                } else {
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static void initialize() {
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
//            return find(parent[a]);
        }
    }
}
