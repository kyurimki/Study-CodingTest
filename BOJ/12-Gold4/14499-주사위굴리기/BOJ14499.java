import java.io.*;
import java.util.*;

class Dice14499 {
    int x, y, top, bottom, left, right, up, down;

    public Dice14499(int x, int y) {
        this.x = x;
        this.y = y;
        this.top = 0;
        this.bottom = 0;
        this.left = 0;
        this.right = 0;
        this.up = 0;
        this.down = 0;
    }
}

public class BOJ14499 {
    static int N, M;
    static int[][] map;

    static int[] cmd;
    static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static Dice14499 dice;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cmd = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++)
            cmd[i] = Integer.parseInt(st.nextToken());
        
        dice = new Dice14499(x, y);
        move(x, y, 0);
    }

    private static void move(int x, int y, int idx) {
        if(idx == cmd.length) {
            System.out.print(sb);
            return ;
        }

        int cx = x + dir[cmd[idx]][0];
        int cy = y + dir[cmd[idx]][1];

        if(cx < 0 || cy < 0 || cx >= N || cy >= M)
            move(x, y, idx+1);
        else {
            roll(cx, cy, cmd[idx]);
            check(cx, cy);
            move(cx, cy, idx+1);
        }
    }

    private static void check(int x, int y) {
        if(map[x][y] == 0)
            map[x][y] = dice.bottom;
        else {
            dice.bottom = map[x][y];
            map[x][y] = 0;
        }
            
        sb.append(dice.top).append('\n');
    }

    private static void roll(int x, int y, int dir) {
        dice.x = x; dice.y = y;
        int t = dice.top, b = dice.bottom, l = dice.left, r = dice.right, u = dice.up, d = dice.down;

        switch(dir) {
            case 1:
                dice.bottom = r;
                dice.right = t;
                dice.top = l;
                dice.left = b;
                break;
            case 2:
                dice.top = r;
                dice.left = t;
                dice.bottom = l;
                dice.right = b;
                break;
            case 3:
                dice.top = u;
                dice.down = t;
                dice.bottom = d;
                dice.up = b;
                break;
            case 4:
                dice.top = d;
                dice.up = t;
                dice.bottom = u;
                dice.down = b;
                break;
        }
    }
}