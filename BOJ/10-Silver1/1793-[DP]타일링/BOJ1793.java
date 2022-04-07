import java.io.*;
import java.math.BigInteger;

public class BOJ1793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for(int i = 3; i <= 250; i++)
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));

        String input = null;
        while((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            System.out.println(dp[n]);
        }
    }
}