import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ16954 {
    static int size = 8;
    static char[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[size][size];
        for(int i = 0; i < size; i++)
            map[i] = br.readLine().toCharArray();
        
        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(size-1, 0));

        while(!q.isEmpty()) {
            int qsize = q.size();
            for(int i = 0; i < qsize; i++) {
                Point p = q.poll();

                if(map[p.x][p.y] == '#') continue;

                for(int j = 0; j < 9; j++) {
                    int cx = p.x + dx[j];
                    int cy = p.y + dy[j];

                    if(cx < 0 || cy < 0 || cx >= size || cy >= size) continue;

                    if(cx == 0 && cy == size-1) return true;

                    if(map[cx][cy] != '#')
                        q.offer(new Point(cx, cy));
                }
            }
            move();
        }
        return false;
    }

    static void move() {
        for(int i = size-1; i >= 0; i--) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == '#') {
                    map[i][j] = '.';

                    if(i != 7) map[i+1][j] = '#';
                }
                    
            }
        }
    }
}