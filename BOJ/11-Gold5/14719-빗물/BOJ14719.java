import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class BOJ14719 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) blocks[i] = Integer.parseInt(st.nextToken());

        int left, right, sum = 0;
        for(int i = 1; i < W; i++) {
            left = right = 0;
            for(int j = 0; j < i; j++)
                left = Math.max(left, blocks[j]);
            
            for(int j = i+1; j < W; j++)
                right = Math.max(right, blocks[j]);
            
            if(blocks[i] < left && blocks[i] < right)
                sum += Math.min(left, right)-blocks[i];
        }
        System.out.println(sum);
    }
}