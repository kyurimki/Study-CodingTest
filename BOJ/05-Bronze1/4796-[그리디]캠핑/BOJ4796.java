import java.io.*;
import java.util.*;

public class BOJ4796 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int phase = 0;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            phase++;
            calcDays(phase, L, P, V);
        }
        System.out.print(sb);
    }

    static void calcDays(int phase, int L, int P, int V) {
        int days = (V/P)*L + Math.min(V%P, L);
        
        sb.append("Case "+ phase + ": " + days).append('\n');
    }
}