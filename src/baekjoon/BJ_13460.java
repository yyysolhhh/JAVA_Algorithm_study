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
			
			if (r_marble.y == holeY && r_marble.x == holeX && b_marble.y != holeY && b_marble.x != holeX)
				return (r_marble.cnt);
			for (int i = 0; i < 4; i++) {
				ny = 
			}
		}

	}
}
