import java.io.*;
import java.util.*;

public class BOJ1766 {
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
        System.out.println(solveProblems(orders, b4Cnt));
    }

    static StringBuilder solveProblems(ArrayList<Integer>[] orders, int[] b4Cnt) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(b4Cnt[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for(Integer next : orders[cur]) {
                b4Cnt[next]--;
                if(b4Cnt[next] == 0) pq.add(next);
            }
        }

        return sb;
    }
}