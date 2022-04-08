import java.io.*;
import java.util.*;

public class BOJ20057 {
    static int N;
    static int[][] grid;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] tx = {{-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] ty = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}};
    static int[] ratio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    static int[] move = {1, 1, 2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        grid = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(tornado());
    }

    private static int tornado() {
        int totalOut = 0;
        int cx = N/2;
        int cy = N/2;

        while(true) {
            for(int dir = 0; dir < 4; dir++) {
                for(int c = 0; c < move[dir]; c++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if(!isIn(nx, ny)) return totalOut;

                    int sand = grid[nx][ny];
                    grid[nx][ny] = 0;
                    int spreaded = 0;
                    for(int s = 0; s < 9; s++) {
                        int sx = nx + tx[dir][s];
                        int sy = ny + ty[dir][s];
                        int spread = sand * ratio[s] / 100;

                        if(!isIn(sx, sy))
                            totalOut += spread;
                        else
                            grid[sx][sy] += spread;
                        spreaded += spread;
                    }

                    int ax = nx + dx[dir];
                    int ay = ny + dy[dir];
                    int alphaSand = sand - spreaded;
                    if(!isIn(ax, ay))
                        totalOut += alphaSand;
                    else
                        grid[ax][ay] += alphaSand;
                    
                    cx = nx;
                    cy = ny;
                }
            }
            for(int i = 0; i < 4; i++)
                move[i] += 2;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}