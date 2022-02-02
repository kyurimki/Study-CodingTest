import java.io.*;
import java.util.*;

public class BOJ14620 {
    private static int n;
    private static int[][] price;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1 ,1};

    private static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        price = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int count, int sum) {
        if(count == 3)
            result = Math.min(result, sum);
        else {
            for(int i = 2; i < n; i++) {
                for(int j = 2; j < n; j++) {
                    if(!visited[i][j] && checkNeigh(i, j)) {
                        visited[i][j] = true;
                        int midSum = sumNeigh(i, j);

                        dfs(count+1, sum+midSum);

                        clearVisited(i, j);
                    }  
                }
            }
        }
    }

    public static boolean checkNeigh(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(visited[cx][cy])
                return false;
        }
        return true;
    }

    public static int sumNeigh(int x, int y) {
        int sum = price[x][y];
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            visited[cx][cy] = true;
            sum += price[cx][cy];
        }
        return sum;
    }

    public static void clearVisited(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            visited[cx][cy] = false;
        }
        visited[x][y] = false;
    }
}