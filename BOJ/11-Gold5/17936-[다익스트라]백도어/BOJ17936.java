import java.io.*;
import java.util.*;

class Node17396 implements Comparable<Node17396> {
    int end;
    long weight;

    public Node17396(int end, long weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node17396 o) {
        return Long.compare(this.weight, o.weight);
    }
}

public class BOJ17936 {
    static int N;
    static ArrayList<Node17396>[] adj;
    static long[] dist;
    static boolean[] visited;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();
        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 1) visited[i] = true;
        }
        visited[N-1] = false;

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj[a].add(new Node17396(b, t));
            adj[b].add(new Node17396(a, t));
        }

        long result = dijkstra();
        System.out.println(result == Long.MAX_VALUE ? -1 : result);
    }

    private static long dijkstra() {
        PriorityQueue<Node17396> pq = new PriorityQueue<>();
        pq.add(new Node17396(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll().end;

            if(visited[cur]) continue;
            visited[cur] = true;

            for(int i = 0; i < adj[cur].size(); i++) {
                Node17396 n = adj[cur].get(i);

                if(!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                    dist[n.end] = dist[cur] + n.weight;
                    pq.add(new Node17396(n.end, dist[n.end]));
                }
            }
        }

        return dist[N-1];
    }
}