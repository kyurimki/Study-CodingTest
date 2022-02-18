import java.io.*;
import java.util.*;

public class BOJ3109 {
    static int R, C;
    static char[][] map;

    static int[] dx = {-1, 0, 1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        answer = 0;
        for(int i = 0; i < R; i++)
            dfs(i, 0);
            
        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) {
        if(y == C-1) {
            answer++;
            return true;
        }

        for(int i = 0; i < 3; i++) {
            int cx = x + dx[i];
            int cy = y + 1;

            if(check(cx, cy) && map[cx][cy] == '.') {
                map[x][y] = 'x';
                if(dfs(cx, cy)) return true;
            }
        }
        return false;
    }

    private static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x >= R || y >= C) return false;

        return true;
    }
}