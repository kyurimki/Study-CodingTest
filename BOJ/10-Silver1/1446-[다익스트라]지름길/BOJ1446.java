import java.io.*;
import java.util.*;

class Route implements Comparable<Route> {
    int end, weight;

    public Route(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Route r) {
        return this.end - r.end;
    }
}

public class BOJ1446 {
    static int D;
    static int[] dist;
    static ArrayList<Route>[] list;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        list = new ArrayList<>[10001];
        for(int i = 0; i <= 10000; i++) list[i] = new ArrayList<Route>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(start > end) continue;
            if(end - start <= weight) continue;

            list[start].add(new Route(end, weight));
        }
        
        dijkstra(0);
        System.out.println(dist[D]);
    }

    public static void dijkstra(int start) {
        if(start > D) return ;

    }
}
