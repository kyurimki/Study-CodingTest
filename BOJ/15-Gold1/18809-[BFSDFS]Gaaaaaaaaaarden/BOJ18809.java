import java.io.*;
import java.util.*;
import java.awt.*;

class Info {
    int time;
    int type;

    Info(int time, int type) {
        this.time = time;
        this.type = type; 
    }
}

public class BOJ18809 {
    static int n, m, g, r;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int GREEN = 3;
    static int RED = 4;
    static int FLOWER = 5;

    static ArrayList<Point> possible;
    static ArrayList<Integer> green;
    static ArrayList<Integer> red;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        possible = new ArrayList<>();
        green = new ArrayList<>();
        red = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2)
                    possible.add(new Point(i, j));
                else if(map[i][j] == 0)
                    visited[i][j] = true;
            }
        }
        spread(GREEN, 0, 0);
        System.out.println(max);
    }

    private static void spread(int type, int start, int count) {
        if(type == GREEN && count == g) {
            spread(RED, 0, 0);
            return ;
        }
        if(type == RED && count == r) {
            bfs();
            return ;
        }
        
        for(int i = start; i < possible.size(); i++) {
            Point p = possible.get(i);
            int x = p.x;
            int y = p.y;
            if(!visited[x][y]) {
                visited[x][y] = true;
                if(type == GREEN)
                    green.add(i);
                else
                    red.add(i);
                spread(type, i+1, count+1);
                visited[x][y] = false;
                if(type == GREEN)
                    green.remove(green.size()-1);
                else
                    red.remove(red.size()-1);
            }
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        Info[][] status = new Info[n][m];

        for(int i = 0; i < g; i++) {
            Point p = possible.get(green.get(i));
            status[p.x][p.y] = new Info(0, GREEN);
            q.offer(p);
        }

        for(int i = 0; i < r; i++) {
            Point p = possible.get(red.get(i));
            status[p.x][p.y] = new Info(0, RED);
            q.offer(p);
        }

        int sum = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int curTime = status[x][y].time;
            int curType = status[x][y].type;

            if(curType == FLOWER) continue;
            
            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(isIn(cx, cy) && map[cx][cy] != 0) {
                    if(status[cx][cy] == null) {
                        status[cx][cy] = new Info(curTime+1, curType);
                        q.offer(new Point(cx, cy));
                    } else if(status[cx][cy].type == GREEN) {
                        if(curType == RED && status[cx][cy].time == curTime+1) {
                            sum++;
                            status[cx][cy].type = FLOWER;
                        }
                    } else if(status[cx][cy].type == RED) {
                        if(curType == GREEN && status[cx][cy].time == curTime+1) {
                            sum++;
                            status[cx][cy].type = FLOWER;
                        }
                    }
                }
            }
        }
        max = max < sum ? sum : max;
    }

    private static boolean isIn(int x, int y) {
        if(-1 < x && x < n && -1 < y && y < m && !visited[x][y]) return true;
        return false;
    }
}