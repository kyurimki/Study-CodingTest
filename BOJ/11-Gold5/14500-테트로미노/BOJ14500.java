import java.io.*;
import java.util.*;

public class BOJ14500 {
    static int N, M;
    static int[][] num;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] ex = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] ey = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) num[i][j] = Integer.parseInt(st.nextToken());
        }

        score = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                visited[i][j] = true;
                dfs(i, j, num[i][j], 1);
                visited[i][j] = false;

                exceptCnt(i, j);
            }
        }
        System.out.println(score);
    }

    private static void dfs(int x, int y, int sum, int count) {
        if(count >= 4) {
            score = Math.max(score, sum);
            return ;
        }

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(!isIn(cx, cy)) continue;

            if(!visited[cx][cy]) {
                visited[cx][cy] = true;
                dfs(cx, cy, sum+num[cx][cy], count+1);
                visited[cx][cy] = false;
            }
        }
    }

    private static void exceptCnt(int x, int y) {
        for(int i = 0; i < 4; i++) {
            boolean flag = true;
            int sum = 0;
            for(int j = 0; j < 4; j++) {
                int cx = x + ex[i][j];
                int cy = y + ey[i][j];

                if(!isIn(cx, cy)) {
                    flag = false;
                    break;
                } else
                    sum += num[cx][cy];
            }
            if(flag) score = Math.max(score, sum);
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 1 || y < 1 || x > N || y > M) return false;
        
        return true;
    }
}