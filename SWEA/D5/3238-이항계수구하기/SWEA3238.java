import java.io.*;
import java.util.*;

public class SWEA3238 {
    static long n, r;
    static int p;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            r = Long.parseLong(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            factorial = new long[p+1];
            factorial[0] = 1;
            for(int i = 1; i <= p; i++)
                factorial[i] = (factorial[i-1]*i) % p;

            long answer = 1;
            while(r != 0 || n != 0) {
                int x = (int)(n % p);
                int y = (int)(r % p);

                if(y > x) {
                    answer = 0;
                    break;
                }

                answer = (answer * factorial[x]) % p;
                for(int i = 0; i < p-2; i++)
                    answer = (answer * factorial[x-y] * factorial[y]) % p;
                
                n /= p;
                r /= p;
            }
            sb.append("#" + t + " " + (answer%p) + "\n");
        }
        System.out.print(sb);
    }
}