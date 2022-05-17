import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ1916 {
    static int N, M;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] visited;
    static Point point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        
        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<Node>());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
        }

        point = new Point(0, 0);
        st = new StringTokenizer(br.readLine());
        point.x = Integer.parseInt(st.nextToken());
        point.y = Integer.parseInt(st.nextToken());

        System.out.println(dijakstra());
    }

    private static int dijakstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(point.x, 0));
        dist[point.x] = 0;

        while(!pq.isEmpty()) {
            Node Node = pq.poll();
            int cur = Node.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node r : list.get(cur)) {
                    if(!visited[r.end] && dist[r.end] > dist[cur] + r.weight) {
                        dist[r.end] = dist[cur] + r.weight;
                        pq.add(new Node(r.end, dist[r.end]));
                    }
                }
            }
        }
        return dist[point.y];
    }
}