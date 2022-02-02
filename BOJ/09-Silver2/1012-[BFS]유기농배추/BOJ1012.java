import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ1012 {
    static int m, n;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            count = 0;
            field = new int[m][n];
            visited = new boolean[m][n];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(field[x][y] == 1 && !visited[x][y])
                        bfs(x, y);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            int xx = (int)p.getX();
            int yy = (int)p.getY();
            for(int i = 0; i < 4; i++) {
                int cx = xx + dx[i];
                int cy = yy + dy[i];
                if(-1 < cx && cx < m && -1 < cy && cy < n &&field[cx][cy] == 1 && !visited[cx][cy]) {
                    q.add(new Point(cx, cy));
                    visited[cx][cy] = true;
                }
            }
        }
        count++;
    }
}