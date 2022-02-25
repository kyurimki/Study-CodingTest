import java.io.*;
import java.util.*;

public class BOJ3584 {
    static int[] parent;
    static ArrayList<ArrayList<Integer>> child;

    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            child = new ArrayList<>();
            for(int i = 0; i <= N; i++)
                child.add(new ArrayList<>());
            for(int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
                child.get(a).add(b);
            }

            for(int i = 1; i <= N; i++) {
                if(parent[i] == 0) {
                    root = i;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            sb.append(nca(u, v)).append('\n');
        }
        System.out.print(sb);
    }

    private static int nca(int u, int v) {
        int uDepth = getDepth(u);
        int vDepth = getDepth(v);

        if(uDepth > vDepth) {
            while(uDepth != vDepth) {
                uDepth--;
                u = parent[u];
            }
        } else if(uDepth < vDepth) {
            while(uDepth != vDepth) {
                vDepth--;
                v = parent[v];
            }
        }

        while(u != v) {
            u = parent[u];
            v = parent[v];
        }

        return u;
    }

    private static int getDepth(int x) {
        if(x == root) return 0;

        return getDepth(parent[x])+1;
    }
}
