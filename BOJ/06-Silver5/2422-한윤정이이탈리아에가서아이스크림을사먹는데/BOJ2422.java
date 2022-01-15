import java.io.*;
import java.util.*;

public class BOJ2422 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] sets = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sets[a][b] = true;
            sets[b][a] = true;
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(sets[i][j]) continue;
                for(int k = j+1; k <= n; k++) {
                    if(!sets[j][k] && !sets[k][i]) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}