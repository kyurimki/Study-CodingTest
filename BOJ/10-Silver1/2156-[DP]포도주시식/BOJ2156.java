import java.util.*;

public class BOJ2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];
        int dp[] = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if(N >= 1) dp[0] = arr[0];
        if(N >= 2) dp[1] = arr[0] + arr[1];
        if(N >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0]+arr[2], arr[1]+arr[2]));
            for(int j = 3; j < N; j++) {
                dp[j] = Math.max(dp[j-1], Math.max(dp[j-2]+arr[j], dp[j-3]+arr[j-1]+arr[j]));
            }
        }
        System.out.println(dp[N-1]);
        sc.close();
    }
}