import java.io.*;

public class BOJ10026 {
    static int n;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] count = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            board[i] = input;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count[0]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
                
                if(visited[i][j]) visited[i][j] = false;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count[1]++;
                }
            }
        }

        System.out.println(count[0] + " " + count[1]);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char toCheck = board[x][y];

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= n || cy < 0 || cy >= n) continue;

            if(!visited[cx][cy] && board[cx][cy] == toCheck)
                dfs(cx, cy);
        }
    }
}