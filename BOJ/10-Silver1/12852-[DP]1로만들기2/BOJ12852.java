import java.util.*;

class Value12852 {
    int n;
    String history;

    public Value12852(int n, String history) {
        this.n = n;
        this.history = history;
    }
}

public class BOJ12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        Value12852[] dp = new Value12852[N+1];
        dp[1] = new Value12852(0, "1");

        for(int i = 2; i <= N; i++) {
            int cur = dp[i-1].n + 1;
            int before = i-1;

            if(i % 2 == 0 && cur > dp[i/2].n+1) {
                cur = dp[i/2].n + 1;
                before = i/2;
            }

            if(i % 3 == 0 && cur > dp[i/3].n+1) {
                cur = dp[i/3].n + 1;
                before = i/3;
            }

            dp[i] = new Value12852(cur, i + " " + dp[before].history); 
        }
        System.out.println(dp[N].n + "\n" + dp[N].history);
    }
}