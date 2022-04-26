import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ17142 {
    static int N, M;
    static int[][] map, visited;

    static ArrayList<Point> virusList;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int available = 0;
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        virusList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 1) available++;
                if(map[i][j] == 2) virusList.add(new Point(i, j));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        choose(new Point[M], 0, 0, virusList.size());
        System.out.println(time == Integer.MAX_VALUE ? -1 : time);
    }

    private static void choose(Point[] picked, int start, int cnt, int limit) {
        if(cnt == M) {
            bfs(picked.clone());

            clear();
            return ;
        }

        for(int i = start; i < limit; i++) {
            picked[cnt] = virusList.get(i);
            choose(picked, i+1, cnt+1, limit);
        }
    }

    private static void bfs(Point[] points) {
        Queue<Point> q = new LinkedList<>();
        for(Point p : points) {
            visited[p.x][p.y] = 0;
            q.offer(p);
        }

        int max = 0, infected = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;
                
                if(map[cx][cy] != 1 && visited[cx][cy] > visited[p.x][p.y]+1) {
                    q.offer(new Point(cx, cy));

                    if(visited[cx][cy] == Integer.MAX_VALUE) infected++;
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                    
                    if(map[cx][cy] == 0) max = Math.max(max, visited[cx][cy]);
                }
            }
        }
        if(infected == available-M) time = Math.min(time, max);
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }

    private static void clear() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                visited[i][j] = Integer.MAX_VALUE;
        }
    }
}