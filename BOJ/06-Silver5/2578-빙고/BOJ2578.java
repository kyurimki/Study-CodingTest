import java.util.*;

public class BOJ2578 {
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                board[i][j] = sc.nextInt();
        }

        for(int i = 1; i <= 25; i++) {
            int x = sc.nextInt();
            out: for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(board[j][k] == x) {
                        board[j][k] = 0;
                        break out;
                    }
                }
            }
            if(count()) {
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }

    private static boolean count() {
        int cnt = 0;
        boolean[] flags = new boolean[4];
        for(int i = 0; i < 5; i++) {
            if(board[i][i] != 0) // 우하향 대각선
                flags[0] = true;
            if(board[i][5-i-1] != 0) // 우상향 대각선
                flags[1] = true;

            flags[2] = false;
            flags[3] = false;
            for(int j = 0; j < 5; j++) {
                if(board[i][j] != 0)  // 가로
                    flags[2] = true;
                if(board[j][i] != 0) // 세로
                    flags[3] = true;
            }
            if(!flags[2]) cnt++;
            if(!flags[3]) cnt++;
        }
        if(!flags[0]) cnt++;
        if(!flags[1]) cnt++;

        if(cnt >= 3) return true;

        return false;
    }
}