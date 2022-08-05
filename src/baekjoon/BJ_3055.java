package Day01.BJ_3055_탈출;
// 맞음

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_3055 {
    static int R, C;
    static char map[][];
    static int dp[][];
    static Queue<Point1> queue;
    static int foundAnswer;

    // 상하좌우
    static final int[] DX = {-1, 1, 0, 0};
    static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point1 st = null;
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'S') {
                    st = new Point1(r, c, 'S');
                } else if (map[r][c] == '*') {
                    queue.add(new Point1(r, c, '*'));
                }
            }
        }
        queue.add(st);

        foundAnswer = bfs();
        if (foundAnswer == -1)
            System.out.println("KAKTUS");
        else
            System.out.println(foundAnswer);
    }

    static int bfs() {
        while (!queue.isEmpty()) {
//          1. 큐에서 꺼내옴
            Point1 p = queue.poll();
//			2. 목적지인가? - D
            if (p.type == 'D')
                return (dp[p.y][p.x]);
//		3. 연결된 곳을 순회 - 상하좌우 (일단 다 연결돼 있다고 생각하는게 편함)
            for (int i = 0; i < 4; i++) {
                int ny = p.y + DY[i];
                int nx = p.x + DX[i];
//		4.	 갈 수 있는가? - 1) 맵 영역 안인지 2) ., D(*인접 x) 3) 방문하지 않은 곳
                if (0 <= ny && ny < R && 0 <= nx && nx < C) {
                    if (p.type == '.' || p.type == 'S') {
                        if ((map[ny][nx] == '.' || map[ny][nx] == 'D') && (dp[ny][nx] == 0)) {
//                      5. 		체크인 - true로 하지 말고 시간으로 기록(지도 사이즈만큼의 int 배열 - term 수)
                            dp[ny][nx] = dp[p.y][p.x] + 1;
//                      6.		큐에 넣음
                            queue.add(new Point1(ny, nx, map[ny][nx]));

                        }
                    } else if (p.type == '*') {
                        if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
                            map[ny][nx] = '*';
                            queue.add(new Point1(ny, nx, '*'));
                        }
                    }
                }
            }
        }
        return (-1);
    }
}

class Point1 {
    int y;
    int x;
    int type;

    public Point1(int y, int x, int type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}