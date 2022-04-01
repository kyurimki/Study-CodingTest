import java.io.*;
import java.util.*;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int[] cost = new int[N];
            for(int i = 0; i < N; i++)
                cost[i] = Integer.parseInt(st.nextToken());
            
            long sum = 0;
            long max = 0;
            for(int i = N-1; i >= 0; i--) {
                if(cost[i] > max) max = cost[i];
                else sum += (max-cost[i]);
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}