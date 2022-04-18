import java.io.*;
import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] wires = new int[K];
        long max = 0;
        for(int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, wires[i]);
        }

        max++;
        long min = 0, mid = 0;
        while(min < max) {
            mid = (min + max) / 2;

            int count = 0;
            for(int i = 0; i < K; i++)
                count += (wires[i] / mid);
            
            if(count < N)
                max = mid;
            else
                min = mid+1;
        }
        System.out.println(min-1);
    }
}