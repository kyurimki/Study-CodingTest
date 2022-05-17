import java.io.*;
import java.util.*;

public class BOJ2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n+1][m+1];
            for(int i = 0; i <= m; i++)
                dp[0][i] = 1;
            
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++)
                    dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
            }
            sb.append(dp[n][m]).append('\n');
        }
        System.out.print(sb);
    }
}