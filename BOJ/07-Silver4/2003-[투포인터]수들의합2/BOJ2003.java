import java.io.*;
import java.util.*;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0, sum = 0, count = 0;
        while(start < N) {
            if(sum > M || end == N) sum -= nums[start++];
            else sum += nums[end++];

            if(sum == M) count++;
        }
        System.out.println(count);
    }
}