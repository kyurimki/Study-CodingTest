import java.io.*;
import java.util.*;

public class BOJ22865 {
    static int N;

    static int friends = 3;
    static int[] fPos;

    static int INF = 100000*100000+1;

    static int[] dist;
    static ArrayList<Node>[] adj;
    // static boolean[] visited;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        fPos = new int[3];
        for(int i = 0; i < friends; i++)
            fPos[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<Node>();
        
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        // visited = new boolean[N+1];

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            adj[d].add(new Node(e, l));
            adj[e].add(new Node(d, l));
        }
        
        for(int f : fPos) {
            int[] v = dijkstra(f);
            for(int i = 1; i <= N; i++)
                dist[i] = Math.min(dist[i], v[i]);
        }
        for(int f : fPos)
            dist[f] = INF;
        
        int max = 0;
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] == INF) continue;

            if(max < dist[i]) {
                answer = i;
                max = dist[i];
            }
        }
        System.out.println(answer);
    }

    static int[] dijkstra(int start) {
        int[] v = new int[N+1];
        Arrays.fill(v, INF);
        boolean[] visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int cur = pq.poll().end;

            if(visited[cur]) continue;
            visited[cur] = true;

            for(Node n : adj[cur]) {
                if(!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                    dist[n.end] = dist[cur] + n.weight;
                    pq.offer(new Node(n.end, dist[n.end]));
                }
            }
        }
        return v;
    }
}