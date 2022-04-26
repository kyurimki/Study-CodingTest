import java.io.*;
import java.util.*;

public class BOJ16964 {
    static int N;

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] toCheck;

    static int idx = 1;
    static boolean flag = true;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        toCheck = new int[N];
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            adj[x].add(y);
            adj[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) toCheck[i] = Integer.parseInt(st.nextToken())-1;

        visited[0] = true;
        dfs(0);
        System.out.println(flag ? 1 : 0);
    }

    private static void dfs(int x) {
        if(!flag) return ;

        HashSet<Integer> set = new HashSet<>();
        for(int y : adj[x]) {
            if(!visited[y]) {
                visited[y] = true;
                set.add(y);
            }
        }

        int size = set.size();
        for(int i = 0; i < size; i++) {
            if(set.remove(toCheck[idx])) {
                dfs(toCheck[idx++]);
            } else {
                flag = false;
                return ;
            }
        }
    }
}