import java.io.*;
import java.util.*;

public class BOJ17070 {
    static int N;
    static boolean[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(st.nextToken().equals("1"))
                    map[i][j] = true;
            }
        }
        dfs(0, 1, 0);

        System.out.println(count);
    }

    private static void dfs(int x, int y, int dir) {
        if(x == N-1 && y == N-1 && !map[x][y]) {
            count++;
            return ;
        }

        if(dir == 0) {
            if(isIn(x, y+1) && !map[x][y+1])
                dfs(x, y+1, 0);
            if(isIn(x+1, y+1) && !map[x][y+1] && !map[x+1][y+1] && !map[x+1][y])
                dfs(x+1, y+1, 2);
        } else if(dir == 1) {
            if(isIn(x+1, y) && !map[x+1][y])
                dfs(x+1, y, 1);
            if(isIn(x+1, y+1) && !map[x][y+1] && !map[x+1][y+1] && !map[x+1][y])
                dfs(x+1, y+1, 2);
        } else if(dir == 2) {
            if(isIn(x, y+1) && !map[x][y+1])
                dfs(x, y+1, 0);
            if(isIn(x+1, y) && !map[x+1][y])
                dfs(x+1, y, 1);
            if(isIn(x+1, y+1) && !map[x][y+1] && !map[x+1][y+1] && !map[x+1][y])
                dfs(x+1, y+1, 2);
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}