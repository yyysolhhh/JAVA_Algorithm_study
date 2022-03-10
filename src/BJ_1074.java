import java.io.*;
import java.util.StringTokenizer;

public class BJ_1074 {
    static int N, r, c;
    static int order;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);
        order = 0;

        search(r, c, size);
        bw.write(order);
        bw.flush();
        bw.close();
    }

    static void search(int r, int c, int size) {
        System.out.println(size);
        System.out.println(order);
        if (size == 1)
            return ;
        // 1사분면
        if (r < size / 2 && c < size / 2) {
            search(r, c, size / 2);
        }
        // 2사분면
        else if (r < size / 2 && c >= size / 2) {
            order += size * size / 4;
            search(r, c + size / 2, size / 2);
        }
        // 3사분면
        else if (r >= size / 2 && c < size / 2) {
            order += size * size / 4 + 1;
            search(r + size / 2, c, size / 2);
        }
        // 4사분면
        else {
            order += size * size / 4 + 2;
            search(r + size / 2, c + size / 2, size / 2);
        }
    }
}
