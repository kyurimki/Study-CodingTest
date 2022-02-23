import java.io.*;
import java.util.*;

public class SWEA1861 {
    static int N, start, roomNo, count;
    static int[][] room;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            room = new int[N][N];
            visited = new boolean[N][N];
            roomNo = 0;
            count = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    room[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    start = room[i][j];
                    dfs(i, j, 1);
                }
                    
            }
            sb.append("#" + t + " " + roomNo + " " + count + "\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(check(cx, cy) && (room[cx][cy] == room[x][y]+1))
                dfs(cx, cy, cnt+1);
        }

        if(cnt > count) {
            count = cnt;
            roomNo = start;
        } else if(cnt == count)
            roomNo = Math.min(roomNo, start);
        
        visited[x][y] = false;
    }

    private static boolean check(int x, int y) {
        if(0 <= x && x < N && 0 <= y && y < N && !visited[x][y]) return true;

        return false;
    }
}
