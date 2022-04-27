import java.io.*;
import java.util.*;

public class BOJ15684 {
    static int N, H;
    static int[][] ladder;

    static boolean status = false;
    static int add = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 1;
            ladder[a][b+1] = 2;
        }

        for(int i = 0; i <= 3; i++) {
            add = i;
            dfs(0);
            if(status) break;
        }

        System.out.println(status ? add : -1);
    }

    private static void dfs(int cnt) {
        if(status) return ;
        if(cnt == add) {
            if(check()) status = true;
            return ;
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;

                    dfs(cnt+1);

                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }

    }

    private static boolean check() {
        for(int i = 1; i <= N; i++) {
            int cx = i, cy = 1;
            while(cy <= H) {
                if(ladder[cy][cx] == 1) cx++;
                else if(ladder[cy][cx] == 2) cx--;
                cy++;
            }
            if(cx != i) return false;
        }
        return true;
    }
}