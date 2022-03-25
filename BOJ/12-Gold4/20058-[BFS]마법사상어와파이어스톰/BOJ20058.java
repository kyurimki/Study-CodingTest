import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ20058 {
    static int N, Q;
    static int[][] board;
    static int[] L;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int total = 0;
    static int maxCnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, N);
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++)
            L[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < Q; i++)
            firestorm(L[i]);
        
        count();
        System.out.println(total);
        System.out.println(maxCnt);
    }

    private static void firestorm(int L) {
        board = divide(L);
        board = melt();
    }

    private static int[][] divide(int L) {
        int[][] tmp = new int[N][N];
        L = (int) Math.pow(2, L);

        for(int i = 0; i < N; i += L) {
            for(int j = 0; j < N; j += L)
                rotate(i, j, L, tmp);
        }
        return tmp;
    }

    private static void rotate(int r, int c, int L, int[][] tmp) {
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < L; j++)
                tmp[r+j][c+L-i-1] = board[r+i][c+j];
        }
    }

    private static int[][] melt() {
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++)
            tmp[i] = Arrays.copyOf(board[i], N);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;

                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if(isIn(cx, cy) && board[cx][cy] > 0)
                            cnt++;
                }

                if(cnt < 3)
                    tmp[i][j]--;
            }
        }
        return tmp;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }

    private static void count() {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] > 0 && !visited[i][j]) {
                    total += board[i][j];
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    int count = 1;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        
                        for(int k = 0; k < 4; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];

                            if(isIn(cx, cy) && board[cx][cy] > 0 && !visited[cx][cy]) {
                                count++;
                                visited[cx][cy] = true;
                                q.offer(new Point(cx, cy));
                                total += board[cx][cy];
                            }
                        }
                    }
                    maxCnt = Math.max(count, maxCnt);
                }
            }
        }
    }
}