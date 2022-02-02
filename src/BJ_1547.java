import java.io.*;
import java.util.StringTokenizer;

public class BJ_1547 {
    static int M;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        int X, Y;
        ans = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            if (ans == X) {
                ans = Y;
            } else if (ans == Y) {
                ans = X;
            }
        }
        if (ans > 3) {
            bw.write(-1 + "");
        } else {
            bw.write(ans + "");
        }
        bw.flush();
        bw.close();
    }
}
