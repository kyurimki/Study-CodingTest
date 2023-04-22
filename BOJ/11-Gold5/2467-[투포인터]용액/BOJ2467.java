import java.io.*;
import java.util.*;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) solutions[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = N-1;
        int min = Integer.MAX_VALUE;
        int[] picked = new int[2];
        while(start < end) {
            int result = solutions[start] + solutions[end];
            if(Math.abs(result) < min) {
                min = Math.abs(result);
                picked[0] = solutions[start];
                picked[1] = solutions[end];
            }

            if(result > 0) end--;
            else start++;
        }
        System.out.println(picked[0] + " " + picked[1]);
    }
}