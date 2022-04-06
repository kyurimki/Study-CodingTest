import java.io.*;
import java.util.*;

class Node1922 implements Comparable<Node1922> {
    int to, w;

    public Node1922(int to, int w) {
        this.to = to;
        this.w = w;
    }

    @Override
    public int compareTo(Node1922 o) {
        return Integer.compare(this.w, o.w);
    }
}

public class BOJ1922 {
    static int N, M;
    static ArrayList<Node1922>[] list;

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
            list[a].add(new Node1922(b, c));
            list[b].add(new Node1922(a, c));
        }
        prim();
        System.out.println(sum);
    }

    private static void prim() {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node1922> pq = new PriorityQueue<>();
        pq.add(new Node1922(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node1922 node = pq.poll();

            if(visited[node.to]) continue;
            visited[node.to] = true;
            sum += node.w;

            if(++cnt == N) break;

            for(int i = 0; i < list[node.to].size(); i++) {
                Node1922 next = list[node.to].get(i);
                if(visited[next.to]) continue;

                pq.offer(next);
            }
        }
    }
}