import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ17836 {
    static int N, M;
    static Point gram;
    static boolean[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M];
        initVisited();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 2) {
                    gram = new Point(i, j);
                    map[i][j] = true;
                } else if(value == 0) map[i][j] = true;
            }
        }

        int time = Integer.min(Integer.MAX_VALUE, move());
        if(visited[gram.x][gram.y] != -1) {
            int shortcut = visited[gram.x][gram.y] + (N-1-gram.x) + (M-1-gram.y);
            time = Integer.min(time, shortcut);
        }

        System.out.println(time > T ? "Fail" : time);
    }

    static int[][] initVisited() {
        for(int i = 0; i < N; i++) Arrays.fill(visited[i], -1);
        visited[0][0] = 0;
        return visited;
    }

    static int move() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(!isInMap(x, y) || !map[x][y]) continue;

                if(visited[x][y] == -1) {
                    visited[x][y] = visited[p.x][p.y] + 1;
                    q.add(new Point(x, y));
                }
            }
        }
        return visited[N-1][M-1] == -1 ? Integer.MAX_VALUE : visited[N-1][M-1];
    }

    static boolean isInMap(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}