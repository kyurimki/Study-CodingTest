import java.io.*;
import java.util.*;

public class BOJ11402 {
    static long N, K;
    static int M;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        factorial = new long[M+1];
        factorial[0] = 1;
        for(int i = 1; i <= M; i++)
            factorial[i] = (factorial[i-1]*i) % M;

        long answer = 1;
        while(N != 0 || K != 0) {
            int x = (int)(N % M);
            int y = (int)(K % M);

            if(y > x) {
                answer = 0;
                break;
            }

            answer = (answer * factorial[x]) % M;
            for(int i = 0; i < M-2; i++)
                answer = (answer * factorial[x-y] * factorial[y]) % M;
            
            N /= M;
            K /= M;
        }
        System.out.println(answer%M);
    }
}