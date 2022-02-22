import java.io.*;
import java.util.*;

public class SWEA7465 {
    static int[] ppl;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[] status = new boolean[N+1];
            ppl = new int[N+1];
            for(int i = 1; i <= N; i++)
                ppl[i] = i;

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                union(from, to);
            }

            int count = 0;
            for(int i = 1; i <= N; i++) {
                int x = find(i);
                if(!status[x]) count++;

                status[x] = true;
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.print(sb);
    }

    private static int find(int a) {
        if(ppl[a] == a) return a;
        else return ppl[a] = find(ppl[a]);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x != y) ppl[y] = x;
    }
}