import java.io.*;
import java.util.*;

public class BOJ21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n+1];
        int[] sum = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) level[i] = Integer.parseInt(st.nextToken());
        
        if(level[0] > level[1]) sum[0] = 1;
        if(level.length > 2) {
            for(int i = 1; i < n; i++) sum[i] = sum[i-1] + (level[i] > level[i+1] ? 1 : 0);
        }

        int q = Integer.parseInt(br.readLine());
        for(int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            
            sb.append(sum[y] - sum[x]).append('\n');
        }
        System.out.println(sb);
    }
}