import java.io.*;
import java.util.*;

public class BOJ16432 {
    static int N;
    static int[] answer;
    static boolean[][] check;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        check = new boolean[N+1][10];
        list = new ArrayList[N];
        answer = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j < m; j++)
                list[i].add(Integer.parseInt(st.nextToken()));
        }

        System.out.print(dfs(0, 0) ? sb : "-1\n"); 
    }

    private static boolean dfs(int cnt, int prev) {
        if(cnt == N) {
            for(int i = 0; i < N; i++)
                sb.append(answer[i]).append('\n');
            return true;
        }

        for(int i = 1; i < 10; i++) {
            if(i == prev) continue;
            if(list[cnt].contains(i) && !check[cnt+1][i]) {
                check[cnt+1][i] = true;
                answer[cnt] = i;
                if(dfs(cnt+1, i)) return true;
            }
        }
        return false;
    }
}