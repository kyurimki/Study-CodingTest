import java.io.*;
import java.util.*;

public class BOJ17144 {
    static int R, C, T;
    static int[][] room;
    static ArrayList<Integer> purifierX;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T  = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        purifierX = new ArrayList<>();
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1) purifierX.add(i);
            }
        }

        while(T-- > 0) {
            spread();
            run();
        }

        int sum = 2;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                sum += room[i][j];
        }
        System.out.println(sum);
    }

    private static void spread() {
        int[][] result = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(room[i][j] != 0) {
                    int cnt = 0;
                    int diffuse = room[i][j]/5;
                    for(int k = 0; k < 4; k++) {
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if(isIn(cx, cy) && room[cx][cy] != -1) {
                            result[cx][cy] += diffuse;
                            cnt++;
                        }
                    }
                    result[i][j] += room[i][j] - diffuse*cnt;
                }
            }
        }
        room = result;
    }

    private static boolean isIn(int x, int y) {
        if(-1 < x && x < R && -1 < y && y < C) return true;
        return false;
    }

    private static void run() {
        int up = purifierX.get(0);
        for(int i = up-1; i > 0; i--)
            room[i][0] = room[i-1][0];
        
        for(int j = 0; j < C-1; j++)
            room[0][j] = room[0][j+1];
        
        for(int i = 0; i < up; i++)
            room[i][C-1] = room[i+1][C-1];
        
        for(int j = C-1; j > 1; j--)
            room[up][j] = room[up][j-1];
        room[up][1] = 0;

        int down = purifierX.get(1);
        for(int i = down+1; i < R-1; i++)
            room[i][0] = room[i+1][0];
        
        for(int j = 0; j < C-1; j++)
            room[R-1][j] = room[R-1][j+1];
        
        for(int i = R-1; i > down; i--)
            room[i][C-1] = room[i-1][C-1];
        
        for(int j = C-1; j > 1; j--)
            room[down][j] = room[down][j-1];
        room[down][1] = 0;
    }
}