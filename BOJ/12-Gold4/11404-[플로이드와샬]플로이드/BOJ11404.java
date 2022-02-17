import java.io.*;
import java.util.*;

public class BOJ11404 {
    static int n;
    static int[][] dist;

    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        dist = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        floydWarshall();
    }

    private static void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dist[i][j] >= INF) sb.append("0 ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}