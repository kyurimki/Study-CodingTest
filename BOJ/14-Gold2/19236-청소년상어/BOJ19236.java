import java.io.*;
import java.util.*;

class Fish19236 {
    int x, y, s, d;

    public Fish19236(int x, int y, int s, int d) {
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.s + " " + this.d;
    }
}

public class BOJ19236 {
    static int SIZE = 4;
    static Fish19236[][] board;
    
    static Fish19236 shark;
    static Fish19236[] fishes;
    static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    static int max;
    static boolean status = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new Fish19236[SIZE][SIZE];
        fishes = new Fish19236[SIZE*SIZE];
        for(int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())-1;
                fishes[a-1] = new Fish19236(i, j, a, b);
                board[i][j] = fishes[a-1];
            }
        }
        shark = board[0][0];
        int eaten = shark.s;
        max = eaten;
        shark.s = 0;
        board[0][0] = null;

        
        // while(status) {
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++)
                    System.out.println(i + " " + j + " " + (board[i][j] != null ? board[i][j].toString() : "NULL"));
                System.out.println();
            }
            fishMove();
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++)
                    System.out.println(i + " " + j + " " + (board[i][j] != null ? board[i][j].toString() : "NULL"));
                System.out.println();
            }
            // sharkMove(eaten);
        // }
        
    }

    private static void fishMove() {
        for(Fish19236 f : fishes) {
            Fish19236 tmp = null;

            int tmpD = f.d;
            for(int i = 0; i < 8; i++) {
                tmpD = (tmpD+i)%8;
                int x = f.x + dir[tmpD][0];
                int y = f.y + dir[tmpD][1];

                if(isIn(x, y) && board[x][y].x != shark.x && board[x][y].y != shark.y) {
                    tmp = board[x][y];

                    board[x][y] = board[f.x][f.y];
                    board[x][y].x = f.x;
                    board[x][y].y = f.y;
                    
                    board[f.x][f.y] = tmp;
                    if(tmp != null) {
                        board[f.x][f.y].x = tmp.x;
                        board[f.x][f.y].y = tmp.y;
                    }
                    f.d = tmpD;
                    break;
                }
            }
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++)
                    System.out.println(i + " " + j + " " + (board[i][j] != null ? board[i][j].toString() : "NULL"));
                System.out.println();
            }
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        return true;
    }
}
