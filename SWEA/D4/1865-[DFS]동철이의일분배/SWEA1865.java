import java.io.*;
import java.util.*;

public class SWEA1865 {
    static double[][] p;
    static int N;
    static double max;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            max = 0.0;

            p = new double[N+1][N+1];
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++)
                    p[i][j] = Double.parseDouble(st.nextToken())/100;
            }

            visited = new boolean[N+1];
            for(int i = 1; i <= N; i++)
                dfs(i, 1, 1.0);

            sb.append("#" + t + " ");
            sb.append(String.format("%.6f", max*100)).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int x, int cnt, double result) {
        result *= p[x][cnt];
        visited[x] = true;

        if(cnt == N) {
            if(max < result)
                max = result;
            visited[x] = false;
            return ;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && result * p[i][cnt+1] > max)
                dfs(i, cnt+1, result);
        }
        visited[x] = false;
    }
}