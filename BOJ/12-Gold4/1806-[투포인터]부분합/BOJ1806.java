import java.io.*;
import java.util.*;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] series = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) series[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int min = N+1;
        int sum = 0;
        while(true) {
            if(sum >= S) {
                sum -= series[start];
                min = Math.min(min, end-start);
                start++;
            } else if(end == N) break;
            else sum += series[end++];
        }
        System.out.println(min == (N+1) ? 0 : min);
    }
}