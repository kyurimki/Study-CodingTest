import java.io.*;
import java.util.*;

public class BOJ21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] input = new long[N];
        long[] leftSum = new long[N];
        long[] rightSum = new long[N];
        for(int i = 0; i < N; i++)
            input[i] = Long.parseLong(st.nextToken());

        leftSum[0] = input[0];
        rightSum[N-1] = input[N-1];
        for(int i = 1; i < N; i++) {
            leftSum[i] = leftSum[i-1] + input[i];
            rightSum[N-i-1] = rightSum[N-i]+input[N-i-1];
        }

        long max = 0;
        for(int i = 1; i < N-1; i++) {
            max = Math.max(max, leftSum[N-1]-leftSum[i]-input[i]+rightSum[0]-input[0]); // 벌~벌~통
            max = Math.max(max, rightSum[0]-rightSum[i]-input[i]+rightSum[0]-input[N-1]); // 통~벌~벌
            max = Math.max(max, leftSum[i]-input[0]+rightSum[i]-rightSum[N-1]); // 벌~통~벌
        }
        System.out.println(max);
    }
}