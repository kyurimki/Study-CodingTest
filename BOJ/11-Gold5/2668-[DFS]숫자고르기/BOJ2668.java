import java.io.*;
import java.util.*;

public class BOJ2668 {
    static int[] table;
    static ArrayList<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        table = new int[N+1];
        for(int i = 1; i <= N; i++)
            table[i] = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i : list)
            sb.append(i).append('\n');

        System.out.print(sb);
    }

    static void dfs(int x, int check) {
        if(!visited[table[x]]) {
            visited[table[x]] = true;
            dfs(table[x], check);
            visited[table[x]] = false;
        }
        if(table[x] == check) list.add(check);
    }
}