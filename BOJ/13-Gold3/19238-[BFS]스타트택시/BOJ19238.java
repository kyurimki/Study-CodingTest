import java.io.*;
import java.util.*;
import java.awt.Point;

class Taxi19238 {
    int x, y, fuel;

    public Taxi19238() {}
}

public class BOJ19238 {
    static int N, M, fuel;
    static int[][] map;

    static Taxi19238 taxi;
    static ArrayList<int[]> customers;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean status = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        taxi = new Taxi19238();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        taxi.fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi.x = Integer.parseInt(st.nextToken())-1;
        taxi.y = Integer.parseInt(st.nextToken())-1;

        customers = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int[] tmp = new int[4];
            tmp[0] = Integer.parseInt(st.nextToken())-1;
            tmp[1] = Integer.parseInt(st.nextToken())-1;
            tmp[2] = Integer.parseInt(st.nextToken())-1;
            tmp[3] = Integer.parseInt(st.nextToken())-1;

            customers.add(tmp);
        }
        simulation();
        System.out.println(status ? taxi.fuel : -1);
    }

    private static void simulation() {
        while(status && customers.size() != 0) {
            Point p = pickup();
            if(p != null)
                move(p);
        }
    }

    private static Point pickup() {
        Point pos = new Point();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(taxi.x, taxi.y));

        int[][] visited = new int[N][N];
        initVisit(visited);
        visited[taxi.x][taxi.y] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && map[cx][cy] != -1 && visited[cx][cy] > visited[p.x][p.y]+1) {
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                    q.offer(new Point(cx, cy));
                }
            }
        }
        int dist = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < customers.size(); i++) {
            int d = visited[customers.get(i)[0]][customers.get(i)[1]];
            if(d < taxi.fuel && d < dist) {
                dist = d;
                idx = i;
            } else if(d < taxi.fuel && d == dist) {
                int x = customers.get(i)[0];
                int y = customers.get(i)[1];
                if(x < customers.get(idx)[0] || (x == customers.get(idx)[0] && y < customers.get(idx)[1]))
                    idx = i;
            }
        }
        if(idx == -1) {
            status = false;
        } else {
            taxi.fuel -= dist;
            taxi.x = customers.get(idx)[0];
            taxi.y = customers.get(idx)[1];
            
            pos.x = customers.get(idx)[2];
            pos.y = customers.get(idx)[3];

            customers.remove(idx);
        }
        return pos;
    }

    private static void move(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(taxi.x, taxi.y));

        int[][] visited = new int[N][N];
        initVisit(visited);
        visited[taxi.x][taxi.y] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(isIn(cx, cy) && map[cx][cy] != -1 && visited[cx][cy] > visited[p.x][p.y]+1) {
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                    q.offer(new Point(cx, cy));
                }
            }
        }

        int moved = visited[point.x][point.y];
        if(moved > taxi.fuel) {
            status = false;
            return ;
        }
        taxi.fuel += moved;
        taxi.x = point.x;
        taxi.y = point.y;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }

    private static void initVisit(int[][] visited) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) visited[i][j] = Integer.MAX_VALUE;
                else visited[i][j] = map[i][j];
            }
        }
    }
}