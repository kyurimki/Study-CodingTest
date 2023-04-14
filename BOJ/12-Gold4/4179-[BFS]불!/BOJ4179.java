import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ4179 {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] jhVisited, fireVisited;
    static Queue<Point> jh;
    static Queue<Point> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        jhVisited = new boolean[R][C];
        fireVisited = new boolean[R][C];
        jh = new LinkedList<>();
        fire = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            map[i] = input;

            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'J') {
                    jh.add(new Point(i, j));
                    jhVisited[i][j] = true;
                } else if(map[i][j] == 'F') {
                    fire.add(new Point(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }
        int result = bfs();
        System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result);
    }

    static int bfs() {
        int time = 0;

        while(!jh.isEmpty()) {
            int jhSize = jh.size();
            int fireSize = fire.size();

            for(int i = 0; i < fireSize; i++) {
                Point fNow = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int cx = fNow.x + dx[j];
                    int cy = fNow.y + dy[j];

                    if(isEdge(cx, cy) || map[cx][cy] == '#' || fireVisited[cx][cy]) continue;

                    map[cx][cy] = 'F';
                    fireVisited[cx][cy] = true;
                    fire.add(new Point(cx, cy));
                }
            }

            for(int i = 0; i < jhSize; i++) {
                Point jhNow = jh.poll();
                for(int j = 0; j < 4; j++) {
                    int cx = jhNow.x + dx[j];
                    int cy = jhNow.y + dy[j];
    
                    if(isEdge(cx, cy)) {
                        time++;
                        return time;
                    }
                    if(map[cx][cy] != '.' || jhVisited[cx][cy]) continue;
                    map[cx][cy] = 'J';
                    jhVisited[cx][cy] = true;
                    jh.add(new Point(cx, cy));
                }
            }
            time++;
        }
        return Integer.MAX_VALUE;
    }

    static boolean isEdge(int x, int y) {
        if (x < 0 || y < 0 || x >= R || y >= C) return true;
        return false;
    }
}