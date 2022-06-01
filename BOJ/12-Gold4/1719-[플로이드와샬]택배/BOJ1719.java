import java.io.*;
import java.util.*;

public class BOJ1719 {
    static int n;
    static int[][] time, table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        time = new int[n+1][n+1];
        table = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(time[i], 2000001);
            table[i][i] = -1;
        }
            
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            time[a][b] = c;
            time[b][a] = c;
            table[a][b] = b;
            table[b][a] = a;
        }
        floydWarshall();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                sb.append(i == j ? "-" : table[i][j]).append(j == n ? '\n' : ' ');
        }
        System.out.print(sb);
    }

    static void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j || j == k || k == i) continue;
                    if(time[i][j] > time[i][k]+time[k][j]) {
                        time[i][j] = time[i][k]+time[k][j];
                        table[i][j] = table[i][k];
                    }
                }
            }
        }
    }
}