import java.io.*;
import java.util.*;

public class BOJ11401 {
    static int N, R;
    static final long MOD = 1_000_000_007;
    static long[] factorial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        factorial = new long[4000001];
        factorial[0] = 1;
        for(int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i-1]*i;
            factorial[i] %= MOD;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        long num = 1, deno = 1;
        num = factorial[N];
        deno = (factorial[N-R]*factorial[R]) % MOD;
        deno = pow(deno, MOD-2);

        System.out.println((num*deno)%MOD);
    }

    private static long pow(long deno, long mod) {
        if(mod == 0) return 1;
        else if(mod == 1) return deno;

        if(mod % 2 == 0) {
            long tmp = pow(deno, mod/2);
            return (tmp*tmp) % MOD;
        } else {
            long tmp = pow(deno, mod-1) % MOD;
            return (tmp*deno) % MOD;
        }
    }
}