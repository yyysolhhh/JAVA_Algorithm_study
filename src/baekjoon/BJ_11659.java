package Day08.BJ_11659_구간합구하기4;
// 맞음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659 {

    static int N, M;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + nums[i];
        }

        int i, j;
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            System.out.println(dp[j] - dp[i - 1]);
        }
    }
}
