import java.util.*;

public class BOJ9663 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];

        dfs(0);

        System.out.println(answer);

        sc.close();
    }

    static void dfs(int n) {
        if(n == N) {
            answer++;
            return ;
        }

        for(int k = 0; k < N; k++) {
            if(!visited[n][k]) {
                visited[n][k] = true;
                board[n][k] = 1;

                mark(n, k);

                dfs(n+1);

                board[n][k] = 0;
                returnInit();

                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] == 1) mark(i, j);
                    }
                }

            }
        }
    }

    static void mark(int a, int b) {
        for(int i = a; i < N; i++) visited[i][b] = true;

        int ax = a;
        int by = b;
        while(-1 < ax && ax < N && -1 < by && by < N) visited[ax++][by--] = true;

        while(-1 < a && a < N && -1 < b && b < N) visited[a++][b++] = true;
    }

    static void returnInit() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                visited[i][j] = false;
        }
    }
}