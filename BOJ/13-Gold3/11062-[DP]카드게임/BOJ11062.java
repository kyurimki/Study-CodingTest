import java.io.*;
import java.util.*;

public class BOJ11062 {
    static int[] cards;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            cards = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                cards[i] = Integer.parseInt(st.nextToken());

            dp = new int[2][n][n];
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++)
                        dp[i][j][k] = -1;
                }
            }

            sb.append(play(0, 0, n-1)).append('\n');
        }
        System.out.print(sb);
    }

    private static int play(int turn, int left, int right) {
        if(left == right) {
            if(turn == 0)
                return cards[left];
            else
                return 0;
        }
        
        if(dp[turn][left][right] != -1)
            return dp[turn][left][right];
        
        dp[turn][left][right] = 0;
        if(turn == 0)
            dp[turn][left][right] = Math.max(play(1, left+1, right)+cards[left], play(1, left, right-1)+cards[right]);
        else
            dp[turn][left][right] = Math.min(play(0, left+1, right), play(0, left, right-1));
        
        return dp[turn][left][right];
    }
}