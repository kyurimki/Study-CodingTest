import java.io.*;
import java.util.*;

class Shark17143 {
    int s, d, z; // 상어 위치, 속력, 이동 방향, 크기
    
    public Shark17143(int s, int d, int z) {
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class BOJ17143 {
    static int R, C, M;
    static Queue<Shark17143>[][] grid;

    static int fisherman;
    static int sizeSum;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new LinkedList[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                grid[i][j] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());

            grid[r][c].offer(new Shark17143(s, d, z));
        }

        sizeSum = 0;
        for(fisherman = 0; fisherman < C; fisherman++) {
            fishing();
            move();
        }
        System.out.println(sizeSum);
    }

    private static void fishing() {
        for(int i = 0; i < R; i++) {
            if(grid[i][fisherman].size() != 0) {
                Shark17143 s = grid[i][fisherman].poll();
                sizeSum += s.z;
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void move() {
        Queue<Shark17143>[][] moved = new LinkedList[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                moved[i][j] = new LinkedList<>();
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(grid[i][j].size() != 0) {
                    Shark17143 s = grid[i][j].poll();
                    int x = i;
                    int y = j;
                    for(int k = 1; k <= s.s; k++) {
                        if((x == 0 && s.d == 0) || (y == C-1 && s.d == 2))
                            s.d += 1;
                        if((x == R-1 && s.d == 1) || (y == 0 && s.d == 3))
                            s.d -= 1;

                        x += dir[s.d][0];
                        y += dir[s.d][1];
                    }
                    moved[x][y].offer(s);
                }
            }
        }

        grid = moved;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(grid[i][j].size() > 1) {
                    Shark17143 biggest = grid[i][j].poll();
                    while(!grid[i][j].isEmpty()) {
                        Shark17143 tmp = grid[i][j].poll();
                        if(biggest.z < tmp.z) biggest = tmp;
                    }
                    grid[i][j].offer(biggest);
                }
            }
        }
    }
}