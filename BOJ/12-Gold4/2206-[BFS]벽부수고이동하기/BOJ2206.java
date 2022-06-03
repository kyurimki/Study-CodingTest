import java.io.*;
import java.util.*;

class Info2206 {
    int x, y, cnt;
    boolean destroyed;

    public Info2206(int x, int y, int cnt, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroyed = destroyed;
    }
}

public class BOJ2206 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++)
                map[i][j] = input[j] - '0';
        }

        move();
    }

    static void move() {
        Queue<Info2206> q = new LinkedList<>();
        q.offer(new Info2206(0, 0, 1, false));


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][][] visited = new boolean[N][M][2];

        while(!q.isEmpty()) {
            Info2206 info = q.poll();

            if(info.x == N-1 && info.y == M-1) {
                System.out.println(info.cnt);
                return ;
            }

            for(int i = 0; i < 4; i++) {
                int cx = info.x + dx[i];
                int cy = info.y + dy[i];

                if(cx < 0 || cy < 0 || cx >= N || cy >= M) continue;

                if(map[cx][cy] == 0) {
                    if(!info.destroyed && !visited[cx][cy][0]) {
                        q.add(new Info2206(cx, cy, info.cnt+1, false));
                        visited[cx][cy][0] = true;
                    } else if(info.destroyed && !visited[cx][cy][1]) {
                        q.add(new Info2206(cx, cy, info.cnt+1, true));
                        visited[cx][cy][1] = true;
                    }
                } else {
                    if(!info.destroyed) {
                        q.add(new Info2206(cx, cy, info.cnt+1, true));
                        visited[cx][cy][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}