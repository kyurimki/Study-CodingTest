import java.io.*;
import java.util.*;

public class BOJ2252 {
    static int N;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] orders = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) orders[i] = new ArrayList<>();
        int[] b4Cnt = new int[N+1];
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            orders[A].add(B);
            b4Cnt[B]++;
        }

        System.out.println(getOrder(orders, b4Cnt));
    }

    static StringBuilder getOrder(ArrayList<Integer>[] orders, int[] b4Cnt) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(b4Cnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for(Integer next : orders[cur]) {
                b4Cnt[next]--;
                if(b4Cnt[next] == 0) q.add(next);
            }            
        }

        return sb;
    }
}