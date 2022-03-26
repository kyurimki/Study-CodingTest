import java.io.*;
import java.util.*;

public class BOJ1103 {
    static int N, M;
    static int[][] board, dp;
    static boolean[][] visited;

    static int stage = 0;
    static boolean flag = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                if(input.charAt(j) == 'H')
                    board[i][j] = 0;
                else
                    board[i][j] = input.charAt(j) - '0';
            }
        }
        
        visited[0][0] = true;
        dfs(0, 0, 1);

        if(flag) System.out.println(-1);
        else System.out.println(stage);
    }

    private static void dfs(int x, int y, int count) {
        if(count > stage)
            stage = count;

        dp[x][y] = count;
        for(int i = 0; i < 4; i++) {
            int step = board[x][y];
            int cx = x + dx[i]*step;
            int cy = y + dy[i]*step;

            if(!isIn(cx, cy) || board[cx][cy] == 0) continue;

            if(visited[cx][cy]) {
                flag = true;
                return ;
            }

            if(dp[cx][cy] > count) continue;
            visited[cx][cy] = true;
            dfs(cx, cy, count+1);
            visited[cx][cy] = false;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    } 
} 