import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ2178 {
    static int N, M;
    static int[][] maze, visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                maze[i][j] = input[j] - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(visited[N-1][M-1]);
    }

    private static void bfs() {
        visited[0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;
                if(maze[cx][cy] == 1 && visited[cx][cy] == Integer.MAX_VALUE) {
                    q.offer(new Point(cx, cy));
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                }
            }
        }
    }
    
    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}