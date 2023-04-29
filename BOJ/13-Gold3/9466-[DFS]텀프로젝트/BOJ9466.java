import java.io.*;
import java.util.*;

public class BOJ9466 {
    static int teams;
    static int[] students;
    static boolean[] visited, done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            students = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            teams = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) students[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= n; i++) {
                if(done[i]) continue;
                dfs(i);
            }

            sb.append(n-teams).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int cur) {
        if(done[cur]) return ;
        if(visited[cur]) {
            done[cur] = true;
            teams++;
        }

        visited[cur] = true;
        dfs(students[cur]);
        done[cur] = true;
        visited[cur] = false;
    }
}