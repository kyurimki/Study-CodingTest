import java.io.*;
import java.util.*;
import java.awt.*;

public class JO1082 {
    static int R, C;
    static char[][] map;

    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> fire;
    static Queue<Point> man;
    static int time = 0;
    static Point end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new int[R][C];
        fire = new LinkedList<>();
        man = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'S') {
                    visited[i][j] = 1;
                    man.offer(new Point(i, j));
                } else if(map[i][j] == '*') {
                    visited[i][j] = -1;
                    fire.offer(new Point(i, j));
                } else if(map[i][j] == 'D')
                    end = new Point(i, j);
            }
        }
        int answer = simulation();
        System.out.println(answer == -1 ? "impossible" : answer);
    }

    private static int simulation() {
        while(true) {
            int fsize = fire.size();
            for(int i = 0; i < fsize; i++) {
                Point p = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int cx = p.x + dx[j];
                    int cy = p.y + dy[j];

                    if(isIn(cx, cy) && map[cx][cy] == '.' && visited[cx][cy] == 0) {
                        visited[cx][cy] = -1;
                        map[cx][cy] = '*';
                        fire.offer(new Point(cx, cy));
                    }
                }
            }

            int msize = man.size();
            for(int i = 0; i < msize; i++) {
                Point p = man.poll();
                for(int j = 0; j < 4; j++) {
                    int cx = p.x + dx[j];
                    int cy = p.y + dy[j];
                    if(isIn(cx, cy) && (map[cx][cy] == '.' || map[cx][cy] == 'D') && visited[cx][cy] == 0) {
                        visited[cx][cy] = visited[p.x][p.y] + 1;
                        map[cx][cy] = 'S';
                        man.offer(new Point(cx, cy));
                    }
                }
            }
            if(fire.size() == 0 && man.size() == 0) break;
        }
        if(visited[end.x][end.y] == 0) return -1;
        else return visited[end.x][end.y]-1;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= R || y >= C) return false;
        return true;
    }
}