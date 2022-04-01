import java.io.*;
import java.util.*;
import java.awt.Point;

class RouteInfo1916 implements Comparable<RouteInfo1916> {
    int end, weight;

    RouteInfo1916(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(RouteInfo1916 o) {
        return this.weight-o.weight;
    }
}

public class BOJ1916 {
    static int N, M;
    static ArrayList<ArrayList<RouteInfo1916>> list;
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
            list.add(new ArrayList<RouteInfo1916>());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new RouteInfo1916(end, weight));
        }

        point = new Point(0, 0);
        st = new StringTokenizer(br.readLine());
        point.x = Integer.parseInt(st.nextToken());
        point.y = Integer.parseInt(st.nextToken());

        System.out.println(dijakstra());
    }

    private static int dijakstra() {
        PriorityQueue<RouteInfo1916> pq = new PriorityQueue<>();
        pq.offer(new RouteInfo1916(point.x, 0));
        dist[point.x] = 0;

        while(!pq.isEmpty()) {
            RouteInfo1916 RouteInfo1916 = pq.poll();
            int cur = RouteInfo1916.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(RouteInfo1916 r : list.get(cur)) {
                    if(!visited[r.end] && dist[r.end] > dist[cur] + r.weight) {
                        dist[r.end] = dist[cur] + r.weight;
                        pq.add(new RouteInfo1916(r.end, dist[r.end]));
                    }
                }
            }
        }
        return dist[point.y];
    }
}