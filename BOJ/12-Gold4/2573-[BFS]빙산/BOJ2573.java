import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2573 {
    static int N, M;
    static int[][] glacier;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count, year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        glacier = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                glacier[i][j] = Integer.parseInt(st.nextToken());
                if(glacier[i][j] != 0) count++;
            }
        }

        year = 0;
        while(true) {
            if(!check()) break;
            melt();
            ++year;
            if(count == 0) break;
        }

        System.out.println(count == 0 ? 0 : year);
    }

    private static boolean check() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        out: for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < M-1; j++) {
                if(glacier[i][j] != 0) {
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    break out;
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            cnt++;
            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(glacier[cx][cy] != 0 && !visited[cx][cy]) {
                    q.offer(new Point(cx, cy));
                    visited[cx][cy] = true;
                }
            }
        }

        if(cnt == count) return true;
        return false;
    }

    private static void melt() {
        int[][] tmp = new int[N][M];
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < M-1; j++) {
                if(glacier[i][j] != 0) {
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(glacier[x][y] == 0) cnt++;
                    }
                    tmp[i][j] = glacier[i][j] >= cnt ? glacier[i][j]-cnt : 0;
                    if(tmp[i][j] == 0) count--;
                }
            }
        }
        glacier = tmp;
    }
}