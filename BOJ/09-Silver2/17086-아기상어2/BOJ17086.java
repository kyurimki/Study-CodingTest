import java.io.*;
import java.util.*;

class Shark17086 {
    int x;
    int y;

    public Shark17086(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class BOJ17086 {
    static int n, m;
    
    static int[][] space;
    static int[][] dist;
    static List<Shark17086> sharks;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        space = new int[n][m];
        dist = new int[n][m];
        sharks = new ArrayList<Shark17086>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 1) {
                    sharks.add(new Shark17086(i, j));
                    dist[i][j] = -1;
                } else 
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                max = Math.max(max, dist[i][j]);
        }
        System.out.println(max);
    }

    public static void bfs() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(space[i][j] != 1) {
                    for(int k = 0; k < sharks.size(); k++) {
                        Shark17086 s = sharks.get(k);
                        int x = s.getX();
                        int y = s.getY();
    
                        int d = Math.max(Math.abs(x-i), Math.abs(y-j));
                        dist[i][j] = Math.min(d, dist[i][j]);
                    }
                }
            }
        }
    }
}