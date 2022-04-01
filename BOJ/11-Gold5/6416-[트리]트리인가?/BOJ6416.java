import java.io.*;
import java.util.*;

class Node6416 {
    int u, v;

    public Node6416(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class BOJ6416 {
    static Queue<Node6416> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int k = 1;
        list = new LinkedList<>();
        while(true) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            if(u == -1 && v == -1) break;

            int max = 0;
            while(u != 0 && v != 0) {
                list.add(new Node6416(u, v));

                max = Math.max(max, u);
                max = Math.max(max, v);

                u = sc.nextInt();
                v = sc.nextInt();
            }
            if(isTree(list, max)) sb.append("Case " + k + " is a tree.\n");
            else sb.append("Case " + k + " is not a tree.\n") ;

            k++;
            list.clear();
        }
        sc.close();
        System.out.print(sb);
    }

    private static boolean isTree(Queue<Node6416> list, int max) {
        if(list.size() == 0) return true;
        int[][] edges = new int[max+1][2];

        while(!list.isEmpty()) {
            Node6416 n = list.poll();
            if(edges[n.v][0] != 0) return false;
            edges[n.v][0] = n.u;
            edges[n.u][1]++;
        }

        int root = 0;
        int rootCnt = 0;
        for(int i = 1; i <= max; i++) {
            if(edges[i][0] == 0 && edges[i][1] != 0) {
                root = i;
                rootCnt++;
            }
        }
        if(rootCnt != 1) return false;
        boolean[] visited = new boolean[max+1];
        for(int i = 0; i <= max; i++) {
            if(edges[i][0] == 0) {
                visited[i] = true;
                continue;
            }

            int cnt = 1;
            int cur = i;
            while(cur != root && cnt <= max) {
                cnt++;
                visited[cur] = true;
                cur = edges[cur][0];
            }
            if(cnt > max) return false;
        }
        for(int i = 0; i <= max; i++)
            if(!visited[i]) return false;
        return true;
    }
}