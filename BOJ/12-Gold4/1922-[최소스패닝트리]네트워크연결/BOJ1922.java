import java.io.*;
import java.util.*;

public class BOJ1922 {
    static int N, M;
    static ArrayList<Node>[] list;

    static int sum = 0;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        prim();
        System.out.println(sum);
    }

    private static void prim() {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.end]) continue;
            visited[node.end] = true;
            sum += node.weight;

            if(++cnt == N) break;

            for(int i = 0; i < list[node.end].size(); i++) {
                Node next = list[node.end].get(i);
                if(visited[next.end]) continue;

                pq.offer(next);
            }
        }
    }
}