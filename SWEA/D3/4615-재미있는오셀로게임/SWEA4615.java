import java.io.*;
import java.util.*;

public class SWEA4615 {
    static int n;

    static int[][] board;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            board = new int[n+1][n+1];
            board[n/2][n/2] = 2;
            board[n/2+1][n/2+1] = 2;
            board[n/2+1][n/2] = 1;
            board[n/2][n/2+1] = 1;

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int type = Integer.parseInt(st.nextToken());

                othello(x, y, type);
            }

            int[] count = {0, 0};
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(board[i][j] != 0)
                        count[board[i][j]-1]++;
                }
            }

            sb.append("#" + tc + " ");
            sb.append(count[0] + " " + count[1] + '\n');
        }
        System.out.print(sb);
    }

    private static void othello(int x, int y, int type) {
        board[x][y] = type;
        for(int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            
            while(true) {
                if(!check(cx, cy) || board[cx][cy] == 0)
                    break;
                if(board[cx][cy] != type) {
                    cx += dx[i];
                    cy += dy[i];
                } else
                    break;
            }

            if(check(cx, cy) && board[cx][cy] == type) {
                while(cx != x || cy != y) {
                    board[cx][cy] = type;
                    cx -= dx[i];
                    cy -= dy[i];
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        if(x <= 0 || y <= 0 || x > n || y > n)
            return false;
        
        return true;
    }
}