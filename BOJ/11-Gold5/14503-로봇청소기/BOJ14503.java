import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    static int cleanCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        map[r][c] = -1;
        cleanCnt++;
        clean(r, c, d);

        System.out.println(cleanCnt);
    }

    private static void clean(int r, int c, int d) {
        for(int i = 0; i < 4; i++) {
            d -= 1;
            if(d == -1) d = 3; 
            int rr = r + dx[d];
            int cc = c + dy[d];

            if(map[rr][cc] == 0) {
                map[rr][cc] = -1;
                cleanCnt++;
                clean(rr, cc, d);

                return ;
            }
        }

        int br = r + dx[(d+2)%4];
        int bc = c + dy[(d+2)%4];

        if(map[br][bc] != 1)
            clean(br, bc, d);
    }
}