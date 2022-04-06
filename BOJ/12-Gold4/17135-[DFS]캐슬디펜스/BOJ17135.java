import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ17135 {
    static int N, M, D;
    static int[][] map;
    static int ARCHERS = 3;

    static Queue<Point> enemyList;
    static int maxKill = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[] position = new int[M];
        enemyList = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemyList.offer(new Point(i, j));
                if(i == 0) position[j] = j;
            }
        }
        combination(position, new int[3], new boolean[M], 0, 0);
        System.out.println(maxKill);
    }

    private static void combination(int[] arr, int[] output, boolean[] visited, int start, int count) {
        if(count == 3) {
            int[][] tmp = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++)
                    tmp[i][j] = map[i][j];
            }
            Queue<Point> q = new LinkedList<>();
            int size = enemyList.size();
            for(int i = 0; i < size; i++) {
                Point p = enemyList.poll();
                q.offer(p);
                enemyList.offer(p);
            }
            simulation(tmp, output.clone(), q);
            return ;
        }

        for(int i = start; i < M; i++) {
            visited[i] = true;
            output[count] = i;
            combination(arr, output, visited, i+1, count+1);
            visited[i] = false;
            output[count] = 0;
        }
    }

    private static void simulation(int[][] map, int[] archer, Queue<Point> enemyList) {
        int killed = 0;
        while(!enemyList.isEmpty()) {
            ArrayList<Point> toKill = new ArrayList<>();
            for(int i = 0; i < ARCHERS; i++) {
                int min = Integer.MAX_VALUE;
                Point possible = null;
                int size = enemyList.size();
                for(int j = 0; j < size; j++) {
                    Point p = enemyList.poll();
                    int dist = Math.abs(p.x-N) + Math.abs(p.y-archer[i]);
                    enemyList.offer(p);
                    if(dist > D) continue;
                    if(dist < min) {
                        min = dist;
                        possible = p;
                    } else if(dist == min) {
                        if(possible.y > p.y) possible = p;
                    }
                }
                if(possible != null) toKill.add(possible);
            }
            if(toKill.size() > 0) {
                for(Point p : toKill) {
                    int size = enemyList.size();
                    for(int i = 0; i < size; i++) {
                        Point ep = enemyList.poll();
                        if(ep.x == p.x && ep.y == p.y) {
                            map[p.x][p.y] = 0;
                            killed++;
                        } else
                            enemyList.offer(ep);
                    }
                }
            }
            enemyList = enemyMove(enemyList);
        }
        maxKill = Math.max(maxKill, killed);
    }

    private static Queue<Point> enemyMove(Queue<Point> enemyList) {
        int size = enemyList.size();
        for(int i = 0; i < size; i++) {
            Point p = enemyList.poll();
            int x = p.x+1;
            if(x != N) {
                map[p.x][p.y] = 0;
                map[x][p.y] = 1;
                enemyList.offer(new Point(x, p.y));
            }
        }
        return enemyList;
    }
}