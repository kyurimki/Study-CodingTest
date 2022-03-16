import java.io.*;
import java.util.*;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N][2];
        int[][] dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[j][i] = dp[j-1][i];
                if(i >= items[j-1][0])
                    dp[j][i] = Math.max(dp[j][i], items[j-1][1]+dp[j-1][i-items[j-1][0]]);
            }
        }
        System.out.println(dp[N][K]);
    }
}