/***
 * IDEA:
 * 1. 키 조합으로 2^6=64가지 -> 64가지의 경우의 수를 저장에 비트마스킹 사용
 * 2. 키 획득 -> 문 통과 시 같은 자리 2번 방문의 가능성 => 키 값에 따른 방문 여부 저장 
 ***/

import java.io.*;
import java.util.*;

class Info1194 {
    int x, y, cnt, key;

    Info1194(int x, int y, int cnt, int key) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.key = key;
    }
}

public class BOJ1194 {
    static int N, M;
    static char[][] map;

    static boolean[][][] visited;
    static Info1194 start;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '0')
                    start = new Info1194(i, j, 0, 0);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Info1194> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y][0] = true;

        while(!q.isEmpty()) {
            Info1194 p = q.poll();
            int cnt = p.cnt;
            int key = p.key;

            if(map[p.x][p.y] == '1') return cnt;

            for(int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(!isIn(cx, cy) || map[cx][cy] == '#' || visited[cx][cy][key]) continue;

                if(map[cx][cy] == '.' || map[cx][cy] == '0' || map[cx][cy] == '1') {
                    visited[cx][cy][key] = true;
                    q.offer(new Info1194(cx, cy, cnt+1, key));
                } else if('a' <= map[cx][cy] && map[cx][cy] <= 'z') { // 열쇠일 때
                    int newKey = 1 << (map[cx][cy] - 'a');
                    newKey = newKey | key; // 새로운 키 비트마스킹으로 저장
                    if(!visited[cx][cy][newKey]) {
                        visited[cx][cy][key] = true;
                        visited[cx][cy][newKey] = true;
                        q.offer(new Info1194(cx, cy, cnt+1, newKey));
                    }
                } else if('A' <= map[cx][cy] && map[cx][cy] <= 'Z') { // 문일 때
                    int door = 1 << (map[cx][cy] - 'A');
                    if((key & door) > 0) { // 문에 맞는 열쇠가 있는지 확인
                        visited[cx][cy][key] = true;
                        q.offer(new Info1194(cx, cy, cnt+1, key)); // 문제 조건: 열쇠는 여러 번 사용할 수 있다.
                    }
                }
            }            
        }
        return -1;
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}