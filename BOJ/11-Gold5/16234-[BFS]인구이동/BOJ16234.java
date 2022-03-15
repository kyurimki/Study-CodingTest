import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ16234 {
    static int N, L, R;
    
    static int[][] country;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                country[i][j] = Integer.parseInt(st.nextToken());
        }

        move();

        System.out.println(days);
    }

    private static void move() {
        while(true) {
            visited = new boolean[N][N];
            boolean status = false;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;

                    if(isOpen(i, j)) status = true;
                }
            }
            if(status) days++;
            else return ;
        }
    }

    private static boolean isOpen(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        Queue<Point> union = new LinkedList<>();

        q.add(new Point(r, c));
        int sum = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int cx = p.x;
            int cy = p.y;

            if(visited[cx][cy]) continue;
            visited[cx][cy] = true;
            union.offer(p);
            sum += country[cx][cy];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!isIn(nx, ny) || visited[nx][ny]) continue;

                int sub = Math.abs(country[cx][cy] - country[nx][ny]);
                if(L <= sub && sub <= R)
                    q.offer(new Point(nx, ny));
            }
        }

        if(union.size() < 2) return false;
        sum /= union.size();
        while(!union.isEmpty()) {
            Point up = union.poll();
            country[up.x][up.y] = sum;
        }
        return true;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}