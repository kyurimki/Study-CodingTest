import java.io.*;
import java.util.*;

class Node1753 implements Comparable<Node1753> {
    int vertex, weight;

    public Node1753(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Node1753 o) {
        return this.weight-o.weight;
    }
}

@SuppressWarnings("unchecked")
public class BOJ1753 {
    static int V, E, K;
    static ArrayList<Node1753>[] matrix;
    static int[] dist;
    static boolean[] visited;

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        matrix = new ArrayList[V+1];
        dist = new int[V+1];
        visited = new boolean[V+1];

        for(int i = 1; i <= V; i++)
            matrix[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        K = Integer.parseInt(br.readLine()); // 정점 번호
        dist[K] = 0;
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // from
            int v = Integer.parseInt(st.nextToken()); // to
            int w = Integer.parseInt(st.nextToken()); // 가중치

            matrix[u].add(new Node1753(v, w));
        }

        dijkstra();

        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node1753> pq = new PriorityQueue<>();
        pq.add(new Node1753(K, 0));

        while(!pq.isEmpty()) {
            Node1753 n = pq.poll();
            if(visited[n.vertex])
                continue;
            
            visited[n.vertex] = true;

            for(Node1753 o : matrix[n.vertex]) {
                if(dist[o.vertex] > dist[n.vertex] + o.weight) {
                    dist[o.vertex] = dist[n.vertex] + o.weight;
                    pq.add(new Node1753(o.vertex, dist[o.vertex]));
                }
            }
        }
    }
}