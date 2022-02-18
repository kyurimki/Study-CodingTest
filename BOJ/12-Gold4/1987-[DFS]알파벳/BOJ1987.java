import java.io.*;
import java.util.*;

public class BOJ1987 {
    static int R, C;
    static int[][] board;
    static boolean[] visited;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new boolean[26];
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++)
                board[i][j] = input.charAt(j) - 'A';
        }

        max = Integer.MIN_VALUE;
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {
        if(visited[board[x][y]]) {
            max = Math.max(max, count);
            return ;
        }

        visited[board[x][y]] = true;
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(check(cx, cy))
                dfs(cx, cy, count+1);
        }
        visited[board[x][y]] = false;
    }

    private static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x >= R || y >= C) return false;

        return true;
    }
}