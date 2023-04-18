import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ3055 {
    static int R, C;
    static int[][] dist;
    static char[][] map;
    static Point end;
    static Queue<Point> hedgehogQ, waterQ;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        hedgehogQ = new LinkedList<>();
        waterQ = new LinkedList<>();

        map = new char[R][C];
        dist = new int[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1);
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'D') end = new Point(i, j);
                else if(map[i][j] == 'S') {
                    hedgehogQ.add(new Point(i, j));
                    dist[i][j] = 0;
                } else if(map[i][j] == '*') waterQ.add(new Point(i, j));
            }
        }
        int answer = escape();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    static int escape() {
        while(!hedgehogQ.isEmpty()) {
            int waterSize = waterQ.size();
            while(waterSize-- > 0) {
                Point p = waterQ.poll();

                for(int i = 0; i < 4; i++) {
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];

                    if(!isIn(nextX, nextY) || map[nextX][nextY] == 'X' || map[nextX][nextY] == '*' || map[nextX][nextY] == 'D') continue;
                    map[nextX][nextY] = '*';
                    waterQ.add(new Point(nextX, nextY));
                }
            }

            int hedgehogSize = hedgehogQ.size();
            while(hedgehogSize-- > 0) {
                Point p = hedgehogQ.poll();
                if(p.x == end.x && p.y == end.y) {
                    return dist[p.x][p.y];
                }

                for(int i = 0; i < 4; i++) {
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];

                    if(!isIn(nextX, nextY) || map[nextX][nextY] == 'X' || map[nextX][nextY] == '*' || dist[nextX][nextY] != -1) continue;
                    dist[nextX][nextY] = dist[p.x][p.y] + 1;
                    hedgehogQ.add(new Point(nextX, nextY));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}
