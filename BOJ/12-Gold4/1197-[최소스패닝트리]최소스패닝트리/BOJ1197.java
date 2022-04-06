import java.io.*;
import java.util.*;

class Node1197 implements Comparable<Node1197> {
    int to, weight;

    public Node1197(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1197 o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class BOJ1197 {
    static int V, E;
    static ArrayList<Node1197>[] list;

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
            list[A].add(new Node1197(B, C));
            list[B].add(new Node1197(A, C));
        }

        prim();
        System.out.print(sum);
    }

    private static void prim() {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node1197> pq = new PriorityQueue<>();
        pq.add(new Node1197(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node1197 node = pq.poll();
            if(visited[node.to]) continue;

            visited[node.to] = true;
            sum += node.weight;
            
            if(++cnt == V) break;

            for(int i = 0; i < list[node.to].size(); i++) {
                Node1197 next = list[node.to].get(i);
                if(visited[next.to]) continue;

                pq.add(next);
            }
        }
    }
}