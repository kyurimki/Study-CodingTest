import java.io.*;
import java.util.*;

class Node14284 implements Comparable<Node14284> {
    int end, weight;

    public Node14284(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node14284 o) {
        return this.weight-o.weight;
    }
}

public class BOJ14284 {
    static int n, m, s, t;
    static ArrayList<Node14284>[] list;
    static int[] dist;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node14284(b, c));
            list[b].add(new Node14284(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        System.out.println(dijakstra());
    }

    private static int dijakstra() {
        PriorityQueue<Node14284> pq = new PriorityQueue<>();
        pq.add(new Node14284(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Node14284 node = pq.poll();
            int cur = node.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(int i = 0; i < list[cur].size(); i++) {
                    Node14284 n = list[cur].get(i);
                    if(!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                        dist[n.end] = dist[cur] + n.weight;
                        pq.offer(new Node14284(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[t];
    }
}