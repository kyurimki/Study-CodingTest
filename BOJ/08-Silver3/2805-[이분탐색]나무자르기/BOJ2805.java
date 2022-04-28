import java.io.*;
import java.util.*;

public class BOJ2805 {
    static int N, M;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            height[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(height);

        binarySearch(0, height[N-1]);
    }

    private static void binarySearch(long start, long end) {
        while(start < end) {
            long mid = (start+end) / 2;

            long sum = 0;
            for(int i = 0; i < N; i++)
                sum += (height[i] > mid ? height[i] - mid : 0);

            if(sum >= M)
                start = mid+1;
            else
                end = mid;
        }
        System.out.println(start-1);
    }
}