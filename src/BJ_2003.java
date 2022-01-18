package Day02.BJ_2003;
// 맞음
import java.util.Scanner;

public class BJ_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int l = 0;
        int h = 0;
        int res = 0;
        while (l < N && h < N) {
            int sum = 0;
            for (int i = l; i <= h; i++) {
                sum += A[i];
            }
            // sum == M -> low++
            if (sum == M) {
                res++;
                l++;
            } else if (sum < M) { // sum < M -> high++
                h++;
            } else { // sum > M -> low++
                l++;
            }
        }
        System.out.println(res);

    }
}
