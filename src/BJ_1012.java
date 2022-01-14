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
			
			for (int j = 0; j < K; j++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (map[j][j2] == 1) {
						BFS(j, j2);
					}
				}
			}
		}
	}
	
	public static void BFS(int y, int x) {
		
	}

}
