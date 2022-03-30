import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ5427 {
    static int w, h;
    static char[][] map;

    static int[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Point> fire;
    static Queue<Point> man;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            map = new char[h][w];
            visited = new int[h][w];
            fire = new LinkedList<>();
            man = new LinkedList<>();
            
            for(int i = 0; i < h; i++) {
                char[] input = br.readLine().toCharArray();
                map[i] = input;
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == '@') {
                        man.offer(new Point(i, j));
                        visited[i][j] = 1;
                    } else if(map[i][j] == '*') {
                        fire.offer(new Point(i, j));
                        visited[i][j] = -1;
                    } else if(map[i][j] == '#')
                        visited[i][j] = -1;
                }
            }
            int time = move();
            sb.append(time == -1 ? "IMPOSSIBLE" : time).append('\n');
            man.clear();
            fire.clear();
            map = null;
            visited = null;
        }
        System.out.print(sb);
    }

    private static int move() {
        while(!man.isEmpty()) {
            int fsize = fire.size();
            for(int i = 0; i < fsize; i++) {
                Point p = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int cx = p.x + dx[j];
                    int cy = p.y + dy[j];

                    if(isIn(cx, cy) && map[cx][cy] != '#' && map[cx][cy] != '*') {
                        map[cx][cy] = '*';
                        fire.offer(new Point(cx, cy));
                    }
                }
            }

            int msize = man.size();
            for(int i = 0; i < msize; i++) {
                Point p = man.poll();
                if(p.x == 0 || p.y == 0 || p.x == h-1 || p.y == w-1)
                    return visited[p.x][p.y];
                for(int j = 0; j < 4; j++) {
                    int cx = p.x + dx[j];
                    int cy = p.y + dy[j];
                    if(isIn(cx, cy) && map[cx][cy] == '.') {
                        visited[cx][cy] = visited[p.x][p.y] + 1;
                        map[cx][cy] = '@';
                        man.offer(new Point(cx, cy));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= h || y >= w) return false;
        return true;
    }
}