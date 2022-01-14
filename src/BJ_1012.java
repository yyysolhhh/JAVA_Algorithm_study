import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1012 {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N+1][M+1];
			visited = new boolean[N+1][M+1];
			int res = 0;
			
			for (int j = 0; j < K; j++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			for (int j = 0; j < M; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (map[j][j2] == 1) {
						BFS(j, j2);
						res++;
					}
				}
			}
		}
	}
	
	public static void BFS(int y, int x) {
		Queue<Integer> queue = new LinkedList<>();
		
	}

}
