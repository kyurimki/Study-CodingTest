import java.io.*;
import java.util.*;

public class BOJ17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1. 1번째 풀이: 3차원 배열 사용
        int[][][] dp = new int[3][N+1][3];
        for(int i = 0; i < 3; i++) {
            for(int k = 0; k < 3; k++) {
                if(i == k) {
                    dp[i][1][k] = cost[1][k];
                } else dp[i][1][k] = 1000001;
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 2; j <= N; j++) {
                for(int k = 0; k < 3; k++)
                    dp[i][j][k] = Math.min(dp[i][j-1][(k+1)%3], dp[i][j-1][(k+2)%3]) + cost[j][k];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) continue;
                min = Math.min(min, dp[i][N][j]);
            }
        }

        // 2. 2차원 배열 사용
        // int[][] dp = new int[N+1][3];
        // int min = Integer.MAX_VALUE;
        // for(int i = 0; i < 3; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         if(i == j) dp[1][j] = cost[1][j];
        //         else dp[1][j] = 1000001;
        //     }

        //     for(int j = 2; j <= N; j++) {
        //         dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
        //         dp[j][1] = Math.min(dp[j-1][2], dp[j-1][0]) + cost[j][1];
        //         dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];
        //     }

        //     for(int j = 0; j < 3; j++) {
        //         if(i != j) min = Math.min(min, dp[N][j]);
        //     }
        // }
        System.out.println(min);
    }
}