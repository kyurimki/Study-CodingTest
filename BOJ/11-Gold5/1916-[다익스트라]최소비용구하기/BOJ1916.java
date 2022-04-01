import java.io.*;
import java.util.*;
import java.awt.Point;

class RouteInfo implements Comparable<RouteInfo> {
    int end, weight;

    RouteInfo(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(RouteInfo o) {
        return this.weight-o.weight;
    }
}

public class BOJ1916 {
    static int N, M;
    static ArrayList<ArrayList<RouteInfo>> list;
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
            list.add(new ArrayList<RouteInfo>());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new RouteInfo(end, weight));
        }

        point = new Point(0, 0);
        st = new StringTokenizer(br.readLine());
        point.x = Integer.parseInt(st.nextToken());
        point.y = Integer.parseInt(st.nextToken());

        System.out.println(dijakstra());
    }

    private static int dijakstra() {
        PriorityQueue<RouteInfo> pq = new PriorityQueue<>();
        pq.offer(new RouteInfo(point.x, 0));
        dist[point.x] = 0;

        while(!pq.isEmpty()) {
            RouteInfo RouteInfo = pq.poll();
            int cur = RouteInfo.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(RouteInfo r : list.get(cur)) {
                    if(!visited[r.end] && dist[r.end] > dist[cur] + r.weight) {
                        dist[r.end] = dist[cur] + r.weight;
                        pq.add(new RouteInfo(r.end, dist[r.end]));
                    }
                }
            }
        }
        return dist[point.y];
    }
}