import java.io.*;
import java.util.*;

public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++)
                nums[i][j] = input[j] - '0';
        }

        int max = 1;
        int limit = Math.min(N, M);
        for(int size = 0; size < limit; size++) {
            for(int i = 0; i < N-size; i++) {
                for(int j = 0; j < M-size; j++) {
                    if(nums[i][j] == nums[i+size][j] && nums[i][j] == nums[i][j+size] && nums[i][j] == nums[i+size][j+size])
                        max = Math.max(max, (size+1)*(size+1));
                }
            }
        }
        System.out.println(max);
    }
}