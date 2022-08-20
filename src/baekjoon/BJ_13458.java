package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_13458 {

	static int N, B, C;
	static int[] A;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ans = N;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			if (A[i] > 0) {
				ans += A[i] / C;
				if (A[i] % C != 0)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
