import java.io.*;
import java.util.*;

public class SWEA1238 {
    static int start;
    static int[] visited;
    static ArrayList<Integer>[] graph;

    static int max;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            visited = new int[101];
            graph = new ArrayList[101];

            for(int i = 1; i <= 100; i++)
                graph[i] = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < length/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            max = Integer.MIN_VALUE;
            visited[start] = 1;
            bfs();

            int answer = 0;
            for(int i = 1; i <= 100; i++) {
                if(max != visited[i]) continue;
                answer = Math.max(answer, i);
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.print(sb);
    }
    
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i = 0; i < graph[x].size(); i++) {
                int v = graph[x].get(i);

                if(visited[v] != 0) continue;
                visited[v] = visited[x]+1;
                q.offer(v);
            }
            max = visited[x];
        }
    }
}