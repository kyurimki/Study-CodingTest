import java.io.*;
import java.util.*;

public class BOJ2644 {
    static int n, m;

    static ArrayList<Integer>[] relation;
    static boolean[] visited;

    static int count = 0;
    static int[] toFind = new int[2];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        relation = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            relation[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++) toFind[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x].add(y);
            relation[y].add(x);
        }

        if(relation[toFind[0]].size() == 0 || relation[toFind[1]].size() == 0)
            System.out.println(-1);
        else {
            dfs(toFind[0], 0);
            System.out.println(count == 0 ? -1 : count);
        } 
    }

    private static void dfs(int x, int cnt) {
        if(x == toFind[1]) {
            count = cnt;
            return ;
        }

        visited[x] = true;
        for(int y : relation[x]) {
            if(!visited[y])
                dfs(y, cnt+1);
        }
    }
}