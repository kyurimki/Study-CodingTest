import java.io.*;
import java.util.*;

public class BOJ14225 {
    static int N;
    static int[] S;
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 수열의 크기

        S = new int[N]; // 수열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            S[i] = Integer.parseInt(st.nextToken());
        
        check = new boolean[2000001];
        dfs(0, 0);

        for(int i = 1; i < check.length; i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void dfs(int count, int sum) {
        if(count == N) {
            check[sum] = true;
            return ;
        }

        dfs(count+1, sum);
        dfs(count+1, sum+S[count]);
    }
}