import java.io.*;
import java.util.StringTokenizer;

public class BJ_1074 {
    static int N, r, c;
    static int[][] map;
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
        map = new int[size][size];
        search(0, r, c, size);

        bw.write(map[r][c]);
        bw.flush();
        bw.close();
    }

    static void search(int order, int r, int c, int size) {
        // 1사분면
        if (r < size / 2 && c < size / 2) {

        }
        // 2사분면
        else if (r < size / 2 && c >= size / 2) {

        }
        // 3사분면
        else if (r >= size / 2 && c < size / 2) {

        }
        // 4사분면
        else {
            
        }
        order++;
    }
}
