import java.io.*;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        int[] dp = getSum();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }

    static int[] getSum() {
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = dp[1]+1; dp[3] = dp[1]+dp[2]+1;

        for(int i = 4; i < dp.length; i++) dp[i] = dp[i-3]+dp[i-2]+dp[i-1];

        return dp;
    }
}
