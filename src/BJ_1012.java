import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class position {
	int x;
	int y;
	position(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class BJ_1012 {
	static int M, N, K;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T+1; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			int res = 0;
			
			for (int j = 0; j < K; j++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1 && !visited[i][j]) {
						BFS(j, k);
						res++;
					}
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void BFS(int y, int x) {
		Queue<position> queue = new LinkedList<>();
		position p = new position(y, x);
		queue.offer(p);
		
		while (!queue.isEmpty()) {
			position p1 = queue.poll();
			visited[p1.y][p1.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int ny = p1.y + dy[i];
				int nx = p1.x + dx[i];
				
				if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
					if (map[ny][nx] == 1 && !visited[ny][nx]) {
						position p2 = new position(ny, nx);
						queue.offer(p2);
						visited[p2.y][p2.x] = true;
					}
				}
				
				
			}
		}
	}

}
