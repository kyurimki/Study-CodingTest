import java.io.*;
import java.util.*;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] flies = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int maxSum = 0;
            for(int i = 0; i < n-m+1; i++) {
                for(int j = 0; j < n-m+1; j++) {
                    int s = 0;
                    for(int k = 0; k < m; k++) {
                        for(int l = 0; l < m; l++)
                            s += flies[i+k][j+l];
                    }
                    maxSum = Math.max(maxSum, s);
                }
            }
            System.out.printf("#%d %d\n", tc, maxSum);
        }
    }   
}