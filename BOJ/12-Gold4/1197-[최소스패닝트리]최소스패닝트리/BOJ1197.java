import java.io.*;
import java.util.*;

public class BOJ1197 {
    static int V, E;
    static ArrayList<Node>[] list;

    static long sum = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        prim();
        System.out.print(sum);
    }

    private static void prim() {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.end]) continue;

            visited[node.end] = true;
            sum += node.weight;
            
            if(++cnt == V) break;

            for(int i = 0; i < list[node.end].size(); i++) {
                Node next = list[node.end].get(i);
                if(visited[next.end]) continue;

                pq.add(next);
            }
        }
    }
}