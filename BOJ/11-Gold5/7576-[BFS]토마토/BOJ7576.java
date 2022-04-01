import java.io.*;
import java.util.*;

class Tomato7576 {
    int x;
    int y;

    Tomato7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ7576 {
    static int m;
    static int n;

    static int[][] board;
    static Queue<Tomato7576> q;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        q = new LinkedList<Tomato7576>();
        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    q.add(new Tomato7576(i, j));
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while(!q.isEmpty()) {
            Tomato7576 t = q.poll();
            int x = t.x;
            int y = t.y;

            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(-1 < cx && cx < n && -1 < cy && cy < m && board[cx][cy] == 0) {
                    q.add(new Tomato7576(cx, cy));
                    board[cx][cy] = board[x][y] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) return -1;
                max = Math.max(max, board[i][j]);
            }
        }

        if(max == 1) return 0;
        else return (max-1);
    }
}