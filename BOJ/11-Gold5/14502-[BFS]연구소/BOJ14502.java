import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ14502 {
    static int N, M;
    static int[][] map;

    static ArrayList<Point> available;
    static Queue<Point> virus;
    static int max = 0;

    static int WALLS = 3;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        available = new ArrayList<>();
        virus = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) available.add(new Point(i, j));
                else if(map[i][j] == 2) virus.offer(new Point(i, j));
            }
        }
        combination(available.size(), 0, 0, new int[3]);
        System.out.println(max);
    }

    private static void combination(int size, int count, int start, int[] output) {
        if(count == WALLS) {
            makeWall(output.clone());
            return ;
        }

        for(int i = start; i < size; i++) {
            output[count] = i;
            combination(size, count+1, i+1, output);
        }
    }

    private static void makeWall(int[] output) {
        int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                tmp[i][j] = map[i][j];
        }
        for(int i = 0; i < WALLS; i++) {
            Point p = available.get(output[i]);
            tmp[p.x][p.y] = 1;
        }

        Queue<Point> q = new LinkedList<>(virus);        

        spread(tmp, q);

        for(int i = 0; i < WALLS; i++) {
            Point p = available.get(output[i]);
            tmp[p.x][p.y] = 0;
        }
    }

    private static void spread(int[][] map, Queue<Point> virus) {
        boolean[][] visited = new boolean[N][M];

        while(!virus.isEmpty()) {
            Point p = virus.poll();
            visited[p.x][p.y] = true;
            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;
                if(!visited[cx][cy] && map[cx][cy] == 0) {
                    visited[cx][cy] = true;
                    map[cx][cy] = 2;
                    virus.offer(new Point(cx, cy));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                if(map[i][j] == 0) count++;
        }
        max = Math.max(max, count);
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}