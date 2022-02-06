import java.io.*;
import java.util.*;

public class SWEA1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] customers = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++)
                customers[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(customers);

            sb.append('#').append(tc).append(' ');
            if(check(n, m, k, customers)) sb.append("Possible");
            else sb.append("Impossible");
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean check(int n, int m, int k, int[] customers) {
        for(int i = 0; i < n; i++) {
            int total = customers[i] / m * k;
            if(total < i+1)
                return false;
        }
        return true;
    }
}