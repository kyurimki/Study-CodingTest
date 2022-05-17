import java.io.*;
import java.util.*;

public class BOJ5972 {
    static int N;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll().end;

            if(visited[cur]) continue;
            visited[cur] = true;

            for(int i = 0; i < adj[cur].size(); i++) {
                Node n = adj[cur].get(i);

                if(!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                    dist[n.end] = dist[cur] + n.weight;
                    pq.offer(new Node(n.end, dist[n.end]));
                }
            }
        }
        return dist[N];
    }
}