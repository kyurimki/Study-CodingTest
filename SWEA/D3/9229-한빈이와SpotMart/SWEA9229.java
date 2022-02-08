import java.io.*;
import java.util.*;

public class SWEA9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    int sum = a[i] + a[j];
                    if(sum <= m && max < sum)
                        max = sum;
                }
            }

            if(max == Integer.MIN_VALUE) max = -1;

            sb.append("#" + t + " " + max + '\n');
        }
        System.out.print(sb);
    }
}