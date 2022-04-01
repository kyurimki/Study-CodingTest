import java.io.*;
import java.util.*;

class Dice23288 {
    int top, bottom, left, right, up, down;

    public Dice23288() {
        this.top = 1;
        this.bottom = 6;
        this.left = 4;
        this.right = 3;
        this.up = 5;
        this.down = 2;
    }
}

public class BOJ23288 {
    static int N, M, K;
    static int[][] board;
    static boolean[][] visited;

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우하좌상

    static Dice23288 dice;
    static int curDir;
    static int[] cur;

    static int B;
    static int C;

    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        dice = new Dice23288();
        curDir = 0;
        cur = new int[] {0, 0};
        sum = 0;

        while(K-- > 0)
            play();
        
        System.out.println(sum);
    }

    private static void play() {
        int cx = cur[0] + dir[curDir][0];
        int cy = cur[1] + dir[curDir][1];

        if(isIn(cx, cy)) {
            cur[0] = cx;
            cur[1] = cy;
        } else {
            changeDir(2);
            cur[0] += dir[curDir][0];
            cur[1] += dir[curDir][1];
        }

        roll();

        int A = dice.bottom;
        B = board[cur[0]][cur[1]];
        C = 0;
        initVisited();
        count(cur[0], cur[1]);
        sum += B*C;

        if(A > B)
            changeDir(1);
        else if(A < B)
            changeDir(3);
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }

    private static void changeDir(int d) {
        curDir = (curDir+d)%4;
    }

    private static void roll() {
        int t = dice.top;
        int b = dice.bottom;
        int u = dice.up;
        int d = dice.down;
        int l = dice.left;
        int r = dice.right;

        switch(curDir) {
            case 0:
                dice.bottom = r;
                dice.top = l;
                dice.left = b;
                dice.right = t;
                break;
            case 1:
                dice.up = t;
                dice.down = b;
                dice.bottom = u;
                dice.top = d;
                break;
            case 2:
                dice.bottom = l;
                dice.top = r;
                dice.left = t;
                dice.right = b;
                break;
            case 3:
                dice.up = b;
                dice.down = t;
                dice.bottom = d;
                dice.top = u;
                break;
        }
    }

    private static void initVisited() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j])
                    visited[i][j] = false;
            }
        }
    }

    private static void count(int x, int y) {
        if(board[x][y] != B)
            return ;

        C++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int cx = x + dir[i][0];
            int cy = y + dir[i][1];
            if(isIn(cx, cy) && !visited[cx][cy]) {
                count(cx, cy);
            }
        }
    }
}