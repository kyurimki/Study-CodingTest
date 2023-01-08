import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ17836 {
    static int N, M;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = rescue();
        System.out.println(time > T ? "Fail" : time);
    }

    private static int rescue() {
        int time = Integer.MAX_VALUE;

        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && (visited[cx][cy] == 0 || visited[cx][cy] > visited[p.x][p.y]+1)) {
                    if(map[cx][cy] == 0) {
                        visited[cx][cy] = visited[p.x][p.y] + 1;
                        q.offer(new Point(cx, cy));
                    } else if(map[cx][cy] == 2) {
                        visited[cx][cy] = visited[p.x][p.y] + 1;
                        time = visited[cx][cy] + Math.abs(N-1-cx) + Math.abs(M-1-cy)-1;
                    }
                }
            }
        }
        System.out.println(map[N-1][M-1]);
        time = map[N-1][M-1] != 0 ? Math.min(time, map[N-1][M-1]-1) : time;

        return time;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
