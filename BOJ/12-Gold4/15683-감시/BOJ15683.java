import java.io.*;
import java.util.*;

class CCTV15683 {
    int x, y, t;

    public CCTV15683(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class BOJ15683 {
    static int N, M;
    static int[][] office;

    static int[][][] cctv = {{{}},{{1}, {2}, {3}, {0}}, {{1, 3}, {0, 2}}, {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
                            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, {{0, 1, 2, 3}}};
    static ArrayList<CCTV15683> list;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        list = new ArrayList<>();
        int remain = N*M;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] != 0) remain--;
                if(0 < office[i][j] && office[i][j] <= 5)
                    list.add(new CCTV15683(i, j, office[i][j]));
            }
        }
        scan(office, 0, remain);
        System.out.println(min);
    }

    private static void scan(int[][] office, int idx, int remain) {
        if(idx == list.size()) {
            min = Math.min(min, remain);
            return ;
        }

        int[][] tmp = new int[N][M];
        copy(office, tmp);

        CCTV15683 c = list.get(idx);
        for(int i = 0; i < cctv[c.t].length; i++) {
            int deleted = 0;
            for(int j = 0; j < cctv[c.t][i].length; j++) {
                int d = cctv[c.t][i][j];

                int x = c.x, y = c.y;
                while(true) {
                    x += dx[d];
                    y += dy[d];

                    if(x < 0 || y < 0 || x >= N || y >= M || tmp[x][y] == 6) break;
                    if((1 <= tmp[x][y] && tmp[x][y] <= 5) || tmp[x][y] == -1) continue;

                    tmp[x][y] = -1;
                    deleted++;
                }
            }
            scan(tmp, idx+1, remain-deleted);

            copy(office, tmp);
        }
    }

    private static void copy(int[][] office, int[][] tmp) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                tmp[i][j] = office[i][j];
        }
    }
}
