import java.io.*;
import java.util.*;
import java.awt.Point;

public class SWEA1953 {
    static int N, M, R, C, L;
    static int[][] map;

    static int[][] time;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] pipe = {{false, false, false, false}, {true, true, true, true}, {true, true, false, false}, {false, false, true, true}, {true, false, false, true}, {false, true, false, true}, {false, true, true, false}, {true, false, true, false}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            time = new int[N][M];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(time[i], Integer.MAX_VALUE);
            }
            bfs();

            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++)
                    if(time[i][j] <= L) count++;
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.print(sb);
    }
    
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(R, C));
        time[R][C] = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;
                if(map[cx][cy] == 0) continue;

                int dir = (i%2 == 0) ? (i+1) : (i-1);
                if(pipe[map[p.x][p.y]][i] && pipe[map[cx][cy]][dir] && time[cx][cy] > time[p.x][p.y] + 1) {
                    time[cx][cy] = time[p.x][p.y] + 1;
                    q.offer(new Point(cx, cy));
                }
            }
        }
    }
    
    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}