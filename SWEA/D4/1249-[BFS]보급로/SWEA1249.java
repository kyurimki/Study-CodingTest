import java.io.*;
import java.util.*;
import java.awt.*;

public class SWEA1249 {
    static int N;
    static int[][] map;

    static int[][] time;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            time = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < N; j++)
                    map[i][j] = input[j] - '0';
            }

            for(int i = 0; i < N; i++)
                Arrays.fill(time[i], Integer.MAX_VALUE);
            
            answer = Integer.MAX_VALUE;
            bfs();
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = true;
        time[0][0] = map[0][0];

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == N-1 && p.y == N-1) {
                answer = Math.min(answer, time[N-1][N-1]);
                continue;
            }
            if(answer <= time[p.x][p.y]) continue;

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;

                if(!visited[cx][cy] || time[cx][cy] > time[p.x][p.y]+map[cx][cy]) {
                    visited[cx][cy] = true;
                    time[cx][cy] = time[p.x][p.y]+map[cx][cy];
                    q.offer(new Point(cx, cy));
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}