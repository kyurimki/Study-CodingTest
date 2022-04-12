import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2468 {
    static int N;
    static int[][] area;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maxCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int max = 0;
        area = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if(max < area[i][j]) max = area[i][j];
            }
        }
        simulation(max);

        System.out.println(maxCnt);
    }

    private static void simulation(int max) {
        for(int height = 0; height < max; height++) {
            boolean[][] visited = new boolean[N][N];

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(area[i][j] > height && !visited[i][j]) {
                        cnt++;

                        Queue<Point> q = new LinkedList<>();
                        q.offer(new Point(i, j));

                        while(!q.isEmpty()) {
                            Point p = q.poll();
                            for(int k = 0; k < 4; k++) {
                                int cx = p.x + dx[k];
                                int cy = p.y + dy[k];
                                if(!isIn(cx, cy)) continue;
                                if(area[cx][cy] > height && !visited[cx][cy]) {
                                    visited[cx][cy] = true;
                                    q.offer(new Point(cx, cy));
                                }
                            }
                        }
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}
