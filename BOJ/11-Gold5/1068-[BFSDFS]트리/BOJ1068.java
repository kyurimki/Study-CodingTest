import java.io.*;
import java.util.*;

public class BOJ1068 {
    static int N;
    static int[] nodes;

    static boolean[] visited;
    static int count;

    static int INF = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new int[N];
        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
            if(nodes[i] == -1) root = i;
        }
            
        int toDelete = Integer.parseInt(br.readLine());
        delete(toDelete);

        count = 0;
        visited = new boolean[N];
        countLeaves(root);

        System.out.println(count);
    }

    private static void delete(int node) {
        nodes[node] = INF;
        for(int i = node+1; i < N; i++) {
            if(nodes[i] == node)
                delete(i);
        }
    }

    private static void countLeaves(int head) {
        boolean flag = true;
        visited[head] = true;
        if(nodes[head] != INF) {
            for(int i = 0; i < N; i++) {
                if(nodes[i] == head && !visited[i]) {
                    countLeaves(i);
                    flag = false;
                }
            }
            if(flag) count++;
        }
    }
}