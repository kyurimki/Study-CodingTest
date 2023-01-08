import java.io.*;
import java.util.*;

public class BOJ1548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        int max = 1;
        for(int i = 0; i < N-1; i++) {
            for(int j = N-1; j > i+1; j--) {
                if(A[i] + A[i+1] > A[j]) max = Math.max(max, j-i+1);
            }
        }
        if(max == 1 && N >= 2) max = 2;

        System.out.println(max);
    }
}