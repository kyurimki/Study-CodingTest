import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2667 {
    static int N;
    static boolean[][] map, visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static PriorityQueue<Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N][N];

        count = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(input[j] == '0') visited[i][j] = true;
                else map[i][j] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                if(map[i][j] && !visited[i][j]) count.offer(bfs(i, j));
        }

        System.out.println(count.size());
        while(!count.isEmpty())
            System.out.println(count.poll());
    }

    static int bfs(int x, int y) {
        int count = 1;
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i], cy = p.y + dy[i];
                
                if(!isIn(cx, cy)) continue;
                if(map[cx][cy] && !visited[cx][cy]) {
                    count++;
                    visited[cx][cy] = true;
                    q.offer(new Point(cx, cy));
                }
            }
        }
        return count;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}