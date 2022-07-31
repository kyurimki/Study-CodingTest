import java.io.*;
import java.util.*;

public class BOJ2606 {
    static boolean[] status;
    static ArrayList<Integer>[] connection;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        status = new boolean[N+1];
        connection = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            connection[i] = new ArrayList<>();
        
        int M = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            connection[x].add(y);
            connection[y].add(x);
        }

        dfs(1);

        int cnt = 0;
        for(int i = 2; i <= N; i++)
            if(status[i]) cnt++;
        
        System.out.println(cnt);
    }

    static void dfs(int start) {
        status[start] = true;
        for(Integer dst : connection[start])
            if(!status[dst]) dfs(dst);
    }
}