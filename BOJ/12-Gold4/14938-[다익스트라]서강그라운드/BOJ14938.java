import java.io.*;
import java.util.*;

public class BOJ14938 {
    static int n, m;
    static int[] items;
    static ArrayList<Node>[] list;
    static int max = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        list = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
           
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, l));
            list[b].add(new Node(a, l));
        }

        for(int i = 1; i <= n; i++)
            dijkstra(i);

        System.out.println(max);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()) {
            int cur = pq.poll().end;

            if(visited[cur]) continue;

            visited[cur] = true;
            for(int i = 0; i < list[cur].size(); i++) {
                Node n = list[cur].get(i);
                if(!visited[n.end] && dist[n.end] > dist[cur]+n.weight) {
                    dist[n.end] = dist[cur]+n.weight;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] <= m)
                count += items[i];
        }

        max = Math.max(max, count);
    }
}
