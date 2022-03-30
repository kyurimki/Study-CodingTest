import java.io.*;
import java.util.*;

class TreeNode implements Comparable<TreeNode>{
    int u;
    long w;

    public TreeNode(int u, long w) {
        this.u = u;
        this.w = w;
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.w-o.w > 0 ? 1 : -1;
    }
}

public class SWEA3124 {
    static ArrayList<TreeNode>[] list;
@SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            for(int i = 0; i <= V; i++)
                list[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                list[A].add(new TreeNode(B, C));
                list[B].add(new TreeNode(A, C));
            }
            boolean[] visited = new boolean[V+1];
            PriorityQueue<TreeNode> pq = new PriorityQueue<>();
            pq.add(new TreeNode(1, 0));
            
            int cnt = 0;
            long sum = 0;
            while(!pq.isEmpty()) {
                TreeNode now = pq.poll();
                if(visited[now.u]) continue;

                sum += now.w;
                visited[now.u] = true;

                if(++cnt == V) break;

                for(int i = 0; i < list[now.u].size(); i++) {
                    TreeNode next = list[now.u].get(i);
                    if(visited[next.u]) continue;
                    pq.add(next);
                }
            }
            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.print(sb);
    }
}