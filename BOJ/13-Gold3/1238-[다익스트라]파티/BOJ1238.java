import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ1238 {
    static int N, X;
    static ArrayList<Point>[] graph, reverseGraph;
    static int[][] dist;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 단방향 도로 개수
        X = Integer.parseInt(st.nextToken()); // 파티 장소

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];
        dist = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            graph[start].add(new Point(end, T));
            reverseGraph[end].add(new Point(start, T));
        }

        int max = 0;
        int[][] sum = new int[2][N+1];
        sum[0] = dijakstra(graph);
        sum[1] = dijakstra(reverseGraph);
        for(int i = 1; i <= N; i++) max = Math.max(max, sum[0][i]+sum[1][i]);
        System.out.println(max);
    }

    static int[] dijakstra(ArrayList<Point>[] graph) {
        Queue<Point> q = new LinkedList<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];
        dist[X] = 0;
        q.offer(new Point(X, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(visited[p.x]) continue;
            for(Point next : graph[p.x]) {
                if(!visited[next.x] && dist[next.x] > dist[p.x] + next.y) {
                    dist[next.x] = dist[p.x] + next.y;
                    q.offer(new Point(next.x, dist[next.x]));
                }
            }
        }
        return dist;
    }
}