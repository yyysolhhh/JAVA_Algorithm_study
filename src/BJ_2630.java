import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {
    static int N;
    static int[][] paper;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(N, N / 2, N / 2);
        System.out.println(white);
        System.out.println(blue);
    }

    static void cutPaper(int size, int row, int col) {
        if (size == 1)
            return ;
        int sum = 0;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                sum += paper[i][j];
            }
        }
        if (sum == size * size || sum == 0) {
            if (sum == size * size)
                blue += 1;
            else if (sum == 0)
                white += 1;
        } else {
            cutPaper(size / 2, row, col);
            cutPaper(size / 2, row / 2, col);
            cutPaper(size / 2, row, col / 2);
            cutPaper(size / 2, row / 2, col / 2);
        }
    }
}
