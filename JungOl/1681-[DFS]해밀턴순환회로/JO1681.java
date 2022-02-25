import java.io.*;
import java.util.*;

public class JO1681 {
    static int N;
    static int[][] map;
    static boolean[] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0] = true;
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int cnt, int cost) {
        if(cost >= answer) return ;

        if(cnt == N-1) {
            if(map[start][0] != 0)
                answer = Math.min(answer, cost+map[start][0]);
            return ;
        }

        for(int i = 1; i < N; i++) {
            if(!visited[i] && map[start][i] != 0) {
                visited[i] = true;
                dfs(i, cnt+1, map[start][i]+cost);
                visited[i] = false;
            }
        }
    }
}