import java.io.*;
import java.util.*;


public class BOJ1260 {
    static int n;

    static ArrayList<Integer>[] edges;
    static boolean[] visited;

    static StringBuilder sb;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
        }

        for(int i = 0; i <= n; i++)
            Collections.sort(edges[i]);

        dfs(v);

        sb.append('\n');
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for(int x : edges[v]) {
            if(!visited[x])
                dfs(x);
        }
    }

    private static void bfs(int v) {
        for(int i = 0; i <= n; i++)
            visited[i] = false;

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        sb.append(v + " ");

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int y : edges[x]) {
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    sb.append(y + " ");
                }
            }
        }
    }
}