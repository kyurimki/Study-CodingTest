import java.io.*;
import java.util.*;

public class SWEA5643 {
    static int N, M;
    static ArrayList<Integer>[] taller;
    static ArrayList<Integer>[] shorter;

    static int cnt;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            taller =  new ArrayList[N+1];
            shorter = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) {
                taller[i] = new ArrayList<>();
                shorter[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                taller[a].add(b);
                shorter[b].add(a);
            }

            int total = 0;
            for(int i = 1; i <= N; i++) {
                cnt = 0;
                dfs(taller, i, new boolean[N+1]);
                dfs(shorter, i, new boolean[N+1]);

                if(cnt == N-1) total++;
            }
            sb.append("#" + t + " " + total + "\n");
        }
        System.out.print(sb);
    }

    private static void dfs(ArrayList<Integer>[] list, int start, boolean[] visited) {
        visited[start] = true;

        for(int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);

            if(visited[next]) continue;

            cnt++;
            dfs(list, next, visited);
        }
    }
}