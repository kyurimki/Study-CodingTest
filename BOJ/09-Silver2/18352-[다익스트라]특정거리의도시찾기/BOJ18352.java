import java.io.*;
import java.util.*;

public class BOJ18352 {
    static ArrayList<Integer>[] graph;
    static int[] dist;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) graph[i] = new ArrayList<Integer>();
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
        }

        getDist(X);
        System.out.print(getDistIsK(N, K));
    }

    static void getDist(int start) {
        Queue<Integer> q = new LinkedList<>();

        dist[start] = 0;
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if(dist[next] > dist[now]+1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
    }

    static StringBuilder getDistIsK(int N, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(dist[i] == k) sb.append(i).append('\n');
        }
        if(sb.length() == 0) sb.append(-1).append('\n');
        return sb;
    }
}
