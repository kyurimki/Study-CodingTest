import java.io.*;
import java.util.*;

public class BOJ17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] fuel = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                fuel[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[N+1][M][3]; // 행, 열, 방향
        
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 3; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;
            }
        }

        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++)
                dp[0][j][k] = fuel[0][j];
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                int min = Integer.MAX_VALUE;
                if(j > 0) {
                    for(int k = 0; k < 3; k++) {
                        if(k == 0) continue;
                        min = Math.min(min, dp[i-1][j-1][k]);
                    }
                    dp[i][j][0] = min;
                    if(i != N) dp[i][j][0] += fuel[i][j];
                }
                
                min = Integer.MAX_VALUE;
                if(j < M-1) {
                    for(int k = 0; k < 3; k++) {
                        if(k == 2) continue;
                        min = Math.min(min, dp[i-1][j+1][k]);
                    }
                    dp[i][j][2] = min;
                    if(i != N) dp[i][j][2] += fuel[i][j];
                }

                min = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {
                    if(k == 1) continue;
                    min = Math.min(min, dp[i-1][j][k]);
                }
                dp[i][j][1] = min;
                if(i != N) dp[i][j][1] += fuel[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++)
                if(dp[N][j][k] != 0) answer = Math.min(answer, dp[N][j][k]);
        }

        System.out.println(answer);
    }
}