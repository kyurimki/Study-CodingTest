import java.io.*;
import java.util.*;

public class BOJ2623 {
    static int N;
    static ArrayList<Integer>[] orders;
    static int[] b4Cnt;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        orders = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) orders[i] = new ArrayList<>();
        b4Cnt = new int[N+1];

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            
            int cur = Integer.parseInt(st.nextToken());
            for(int i = 1; i < cnt; i++) {
                int next = Integer.parseInt(st.nextToken());
                orders[cur].add(next);
                b4Cnt[next]++;
                
                cur = next;
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> answers = getOrders();
        if(answers.size() == N) {
            for(Integer answer : answers) sb.append(answer).append('\n');
        } else sb.append(0).append('\n');
        System.out.print(sb);
    }

    static ArrayList<Integer> getOrders() {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(b4Cnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for(Integer next : orders[cur]) {
                b4Cnt[next]--;
                if(b4Cnt[next] == 0) q.add(next);
            }
        }

        return answer;
    }
}