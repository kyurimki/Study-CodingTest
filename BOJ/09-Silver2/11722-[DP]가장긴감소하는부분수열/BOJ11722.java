import java.io.*;
import java.util.*;

public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[i] < A[j] && dp[i] < dp[j]+1) dp[i] = dp[j]+1;
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}