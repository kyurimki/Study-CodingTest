import java.io.*;
import java.util.*;
import java.awt.Point;

class Shark16236 {
    int x, y, size, eaten;

    public Shark16236(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eaten = 0;
    }
}

public class BOJ16236 {
    static int N;
    static int[][] board, visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Shark16236 shark;

    static int time, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    shark = new Shark16236(i, j, 2);
                    board[i][j] = 0;
                }
            }
        }
        simulation();

        System.out.println(time);
    }

    private static void simulation() {
        time = 0;

        ArrayList<Point> fishes = null;
        while(true) {
            fishes = check();

            if(fishes.size() == 0) return ;
            
            Point p = getDistance(fishes);
            if(p.x == N && p.y == N) return ;
            eat(p);
        }
    }

    private static ArrayList<Point> check() {
        ArrayList<Point> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 9 && 0 < board[i][j] && board[i][j] < shark.size) list.add(new Point(i, j));
            }
        }
        return list;
    }

    private static Point getDistance(ArrayList<Point> fishes) {
        int minDist = Integer.MAX_VALUE;
        Point point = new Point(N, N);

        initVisit();
        
        Queue<Point> q = new LinkedList<>();
        int x = shark.x, y = shark.y, size = shark.size;
        q.offer(new Point(x, y));
        visited[x][y] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy)) continue;

                if(board[cx][cy] <= size && visited[cx][cy] == Integer.MAX_VALUE) {
                    q.offer(new Point(cx, cy));
                    visited[cx][cy] = visited[p.x][p.y] + 1;
                    if(0 < board[cx][cy] && board[cx][cy] < size) {
                        if(minDist > visited[cx][cy] || (minDist == visited[cx][cy] && point.x > cx) || (minDist == visited[cx][cy] && point.x == cx && point.y > cy)) {
                            minDist = visited[cx][cy];
                            point.x = cx;
                            point.y = cy;
                        }
                    }
                }
            }
        }
        dist = minDist;
        return point;
    }

    private static void initVisit() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                visited[i][j] = Integer.MAX_VALUE;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }

    private static void eat(Point p) {
        board[p.x][p.y] = 0;
        time += dist;
        shark.x = p.x;
        shark.y = p.y;

        shark.eaten += 1;
        if(shark.eaten == shark.size) {
            shark.size += 1;
            shark.eaten = 0;
        }
    }
}