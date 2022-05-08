import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2589 {
    static int R, C;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'L') {
                    min = Math.max(min, bfs(i, j));
                }
            }
        }
        
        System.out.println(min);
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        int[][] visited = new int[R][C];
        visited[x][y] = 1;

        int max = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && visited[cx][cy] == 0 && map[cx][cy] == 'L') {
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                    q.offer(new Point(cx, cy));
                    max = Math.max(max, visited[cx][cy]);
                }
            }
        }
        return max-1;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }
}