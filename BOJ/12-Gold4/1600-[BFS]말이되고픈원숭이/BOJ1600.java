import java.io.*;
import java.util.*;

class Monkey {
    int x, y, k, cnt;
    
    public Monkey(int x, int y, int k, int cnt) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
    }
}

public class BOJ1600 {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] hy = {-2, 2, -1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.offer(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Monkey p = q.poll();
            if(p.x == H-1 && p.y == W-1) return p.cnt;
            
            if(p.k < K) {
                for(int i = 0; i < 8; i++) {
                    int cx = p.x + hx[i];
                    int cy = p.y + hy[i];

                    if(isIn(cx, cy) && !visited[cx][cy][p.k+1] && map[cx][cy] == 0) {
                        visited[cx][cy][p.k+1] = true;
                        q.offer(new Monkey(cx, cy, p.k+1, p.cnt+1));
                    }
                }
            }

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && !visited[cx][cy][p.k] && map[cx][cy] == 0) {
                    visited[cx][cy][p.k] = true;
                    q.offer(new Monkey(cx, cy, p.k, p.cnt+1));
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= H || y >= W) return false;
        return true;
    }
}