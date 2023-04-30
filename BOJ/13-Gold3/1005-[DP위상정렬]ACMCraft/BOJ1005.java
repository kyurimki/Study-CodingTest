import java.io.*;
import java.util.*;

public class BOJ1005 {
    static int N;
    static int[] D, b4Cnt;
    static ArrayList<Integer>[] orders;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            D = new int[N+1];
            b4Cnt = new int[N+1];
            orders = new ArrayList[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
                orders[i] = new ArrayList<>();
            }

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                orders[X].add(Y);
                b4Cnt[Y]++;
            }
            int W = Integer.parseInt(br.readLine());
            sb.append(build(W)).append('\n');
        }
        System.out.print(sb);
    }

    static int build(int building) {
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[N+1];

        for(int i = 1; i <= N; i++) {
            time[i] = D[i];
            if(b4Cnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(Integer next : orders[cur]) {
                time[next] = Math.max(time[next], time[cur]+D[next]);

                b4Cnt[next]--;
                if(b4Cnt[next] == 0) q.add(next);
            }
        }

        return time[building];
    }
}