import java.io.*;
import java.util.*;
import java.awt.*;

class Point14940 {
    int dist;
    boolean disabled, visited;

    Point14940() {
        this.dist = -1;
        this.disabled = false;
        this.visited = false;
    }
}

public class BOJ14940 {
    static int n, m;
    static Point14940[][] map;
    static Point end;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new Point14940[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = new Point14940();
                int cur = Integer.parseInt(st.nextToken());
                initMap(i, j, cur);
            }
        }
        calculate();
        print();
    }

    static void initMap(int i, int j, int cur) {
        if(cur == 2) {
            end = new Point(i, j);
            map[i][j].dist = 0;
            map[i][j].visited = true;
        } else if(cur == 0) {
            map[i][j].dist = 0;
            map[i][j].disabled = true;
        }
    }

    static void calculate() {
        Queue<Point> q = new LinkedList<>();
        q.add(end);

        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(!isValid(x, y)) continue;

                map[x][y].visited = true;
                map[x][y].dist = map[p.x][p.y].dist+1;
                q.add(new Point(x, y));
            }
        }
    }

    static boolean isValid(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        if(map[x][y].disabled || map[x][y].visited) return false;
        
        return true;
    }

    static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j].dist + " ");
            }
            System.out.println();
        }
    }
}