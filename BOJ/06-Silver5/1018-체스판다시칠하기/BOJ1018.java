import java.io.*;
import java.util.*;

public class BOJ1018 {
    static int n;
    static int m;
    static boolean[][] board;

    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < input.length; j++) {
                if(input[j] == 'W')
                    board[i][j] = true;
            }
        }

        for(int i = 0; i < n-7; i++) {
            for(int j = 0; j < m-7; j++)
                count(i, j);
        }
        System.out.println(min);
    }

    public static void count(int x, int y) {
        int count = 0;
        boolean start = board[x][y];

        for(int i = x; i < x+8; i++) {
            for(int j = y; j < y+8; j++) {
                if(board[i][j] != start)
                    count++;
                
                start = !start;
            }
            start = !start;
        }
        count = Math.min(count, 64-count);

        min = Math.min(count, min);
    }
}