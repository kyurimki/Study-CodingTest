import java.io.*;
import java.util.*;

public class BOJ13023 {
    static int n, m;

    static ArrayList<Integer>[] relation;
    static boolean[] v;

    static int answer = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        relation = new ArrayList[n];
        v = new boolean[n];
        for(int i = 0; i < n; i++) {
            relation[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            relation[n1].add(n2);
            relation[n2].add(n1);
        }

        for(int i = 0; i < n; i++) {
            if(answer == 0)
                dfs(i, 1);
        }
        System.out.println(answer);
    }

    private static void dfs(int n, int depth) {
        if(depth == 5) {
            answer = 1;
            return ;
        }

        v[n] = true;
        for(int i : relation[n]) {
            if(!v[i])
                dfs(i, depth+1);
        }
        v[n] = false;
    }
}