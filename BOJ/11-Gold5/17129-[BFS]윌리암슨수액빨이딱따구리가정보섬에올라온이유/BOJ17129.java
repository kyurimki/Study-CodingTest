import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ17129 {
    static int n, m;
    static char[][] map;
    static int[][] count;

    static Point start;
    static ArrayList<Point> food;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        count = new int[n][m];
        food = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(count[i], Integer.MAX_VALUE);
            for(int j = 0; j < m; j++) {
                if(map[i][j] == '1') count[i][j] = -1;
                else if(map[i][j] == '2') {
                    count[i][j] = 0;
                    start = new Point(i, j);
                } else if(map[i][j] != '0')
                    food.add(new Point(i, j));
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int cx = p.x+dx[i];
                int cy = p.y+dy[i];

                if(isIn(cx, cy) && map[cx][cy] != '1' && count[cx][cy] == Integer.MAX_VALUE) {
                    count[cx][cy] = count[p.x][p.y]+1;
                    q.offer(new Point(cx, cy));
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for(Point p : food)
            max = Math.min(max, count[p.x][p.y]);
        if(max == Integer.MAX_VALUE)
            System.out.println("NIE");
        else {
            System.out.println("TAK");
            System.out.println(max);
        }       
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }
}