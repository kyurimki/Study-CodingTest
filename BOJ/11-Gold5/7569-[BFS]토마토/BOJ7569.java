import java.io.*;
import java.util.*;

class Tomato7569 {
    int z;
    int x;
    int y;

    Tomato7569(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class BOJ7569 {
    static int m;
    static int n;
    static int h;

    static int[][][] board;
    static Queue<Tomato7569> q;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        q = new LinkedList<Tomato7569>();
        board = new int[h][n][m];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k] == 1)
                        q.add(new Tomato7569(i, j, k));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while(!q.isEmpty()) {
            Tomato7569 t = q.poll();
            int z = t.z;
            int x = t.x;
            int y = t.y;

            for(int i = 0; i < 6; i++) {
                int cz = z + dz[i];
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(-1 < cx && cx < n && -1 < cy && cy < m && -1 < cz && cz < h && board[cz][cx][cy] == 0) {
                    q.add(new Tomato7569(cz, cx, cy));
                    board[cz][cx][cy] = board[z][x][y] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(board[i][j][k] == 0) return -1;
                    max = Math.max(max, board[i][j][k]);
                }
            }
        }

        if(max == 1) return 0;
        else return (max-1);
    }
}