import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2638 {
    static int N, M;
    static int[][] grid;

    static boolean[][] isOut;
    static int time = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        isOut = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if(!isLeft()) {
                System.out.println(time);
                break;
            }
            time++;
            markOut();
            melt();
        }
    }

    private static boolean isLeft() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    private static void markOut() {
        resetIsOut();
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        isOut[0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && grid[cx][cy] == 0 && !isOut[cx][cy]) {
                    isOut[cx][cy] = true;
                    q.offer(new Point(cx, cy));
                }     
            }
        }
    }

    private static void melt() {
        ArrayList<Point> toBeMelted = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == 0) continue;

                int count = 0;
                for(int k = 0; k < 4; k++) {
                    if(isOut[i+dx[k]][j+dy[k]]) count++;
                }
                if(count >= 2)
                    toBeMelted.add(new Point(i, j));
            }
        }

        for(Point p : toBeMelted)
            grid[p.x][p.y] = 0;
    }

    private static void resetIsOut() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                if(isOut[i][j]) isOut[i][j] = false;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}