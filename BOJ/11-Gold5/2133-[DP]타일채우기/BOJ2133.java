import java.util.*;

public class BOJ2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[0] = 1; // 아무 것도 없는 상태가 하나의 경우
        
        int answer = 0;
        if(N % 2 == 1) {
            answer = 0;
        } else {
            dp[2] = 3;
            for(int i = 4; i <= N; i+=2) {
                dp[i] = dp[i-2] * dp[2];
                for(int j = i-4; j >= 0; j-=2)
                    dp[i] += dp[j]*2;
            }
            answer = dp[N];
        }
        
        sc.close();
        System.out.println(answer);
    }
}