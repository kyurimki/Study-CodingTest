import java.io.*;

public class BOJ2239 {
    static int[][] board;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            String input = br.readLine();
            for(int j = 0; j < 9; j++)
                board[i][j] = input.charAt(j) - '0';
        }
        dfs(0);
    }

    private static void dfs(int count) {
        if(count == 81) {
            flag = true;
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++)
                    sb.append(board[i][j]);
                sb.append('\n');
            }
            System.out.print(sb);
            return ;
        }

        int x = count / 9;
        int y = count % 9;
        if(board[x][y] != 0)
            dfs(count+1);
        else {
            for(int i = 1; i <= 9; i++) {
                if(!isOK(x, y, i)) continue;
                board[x][y] = i;
                dfs(count+1);
                if(!flag) board[x][y] = 0;
            }
        }
    }

    private static boolean isOK(int x, int y, int z) {
        for(int i = 0; i < 9; i++)
            if(board[i][y] == z || board[x][i] == z) return false;

            int cx = x/3*3;
            int cy = y/3*3;
            for(int j = cx; j < cx+3; j++) {
                for(int k = cy; k < cy+3; k++)
                    if(board[j][k] == z) return false;
            }
        return true;
    }
}