package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Marble {
	int y;
	int x;
	int cnt;

	public Marble(int y, int x, int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class BJ_13460 {
	
	static int N, M;
	static char[][] board;
	static int holeY, holeX;
	static Marble red, blue;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'R') {
					red = new Marble(i, j, 0);
				} else if (board[i][j] == 'B') {
					blue = new Marble(i, j, 0);
				} else if (board[i][j] == 'O') {
					holeY = i;
					holeX = j;
				}
			}
		}
		
		System.out.println(bfs());

	}

	static int bfs() {
		Queue<Marble> redQ = new LinkedList<Marble>();
		Queue<Marble> blueQ = new LinkedList<Marble>();
		
		redQ.add(red);
		blueQ.add(blue);
		
		while (!redQ.isEmpty() && !blueQ.isEmpty()) {
			Marble r_marble = redQ.poll();
			Marble b_marble = blueQ.poll();
			
			if (r_marble.cnt > 10) {
				return (-1);
			}
			
			if (board[b_marble.y][b_marble.x] == 'O') {
				continue;
			} else if (board[r_marble.y][r_marble.x] == 'O') {
				return (r_marble.cnt);
			}
			
//			if (r_marble.y == holeY && r_marble.x == holeX && b_marble.y != holeY && b_marble.x != holeX)
//				return (r_marble.cnt);
			
			for (int i = 0; i < 4; i++) {
				int r_ny = r_marble.y;
				int r_nx = r_marble.x;
				while (true) {
					r_ny += dy[i];
					r_nx += dx[i];
					if (board[r_ny][r_nx] == 'O')
						break;
					else if (board[r_ny][r_nx] == '#') {
						r_ny -= dy[i];
						r_nx -= dx[i];
					}
				}
				
				int b_ny = b_marble.y + dy[i];
				int b_nx = b_marble.x + dx[i];
				while (true) {
					b_ny += dy[i];
					b_nx += dx[i];
					if (board[b_ny][b_nx] == 'O')
						break;
					else if (board[b_ny][b_nx] == '#') {
						b_ny -= dy[i];
						b_nx -= dx[i];
					}
				}
				
				if (r_ny == b_ny && r_nx == b_nx && board[r_ny][r_nx] != 'O') {
					
				}
			}
		} 

	}
}
