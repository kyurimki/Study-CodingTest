import java.io.*;
import java.util.*;

class FireBall {
    int r, c, m, s, d; // (r, c): 위치, 질량, 속력, 방향

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

@SuppressWarnings("unchecked")
public class BOJ20056 {
    static int N, M, K;
    static Queue<FireBall> list;
    static Queue<FireBall>[][] map;
    
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        map = new LinkedList[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                map[i][j] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

           list.offer(new FireBall(r, c, m, d, s));
        }
        
        while(K-- > 0) {
            move();
            check();
        }

        int sum = 0;
        while(!list.isEmpty()) {
            FireBall fb = list.poll();
            sum += fb.m;
        }
        System.out.println(sum);
    }

    private static void move() {
        while(!list.isEmpty()) {
            FireBall fb = list.poll();
            int r = fb.r;
            int c = fb.c;
            int d = fb.d;
            int s = fb.s;

            int cr = r+dir[d][0]*s;
            int cc = c+dir[d][1]*s;
            while(cr < 0) cr += N;
            while(cc < 0) cc += N;
            map[cr%N][cc%N].offer(fb);
        }
    }

    private static void check() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].isEmpty()) continue;
                if(map[i][j].size() == 1) {
                    FireBall fb = map[i][j].poll();
                    list.offer(new FireBall(i, j, fb.m, fb.s, fb.d));
                    continue;
                }

                int size = map[i][j].size();
                int mSum = 0;
                int sSum = 0;
                boolean status = true;
                int op = -1;
                while(!map[i][j].isEmpty()) {
                    FireBall fb = map[i][j].poll();
                    mSum += fb.m;
                    sSum += fb.s;
                    if(op == -1) {
                        if(fb.d % 2 == 0) op = 0;
                        else op = 1;
                    } else
                        if((fb.d+op) % 2 != 0) status = false;
                }
                if(status) op = 0;
                else op = 1;
                
                if(mSum < 5) continue;
                for(int k = op; k < 8; k += 2) {
                    list.offer(new FireBall(i, j, mSum/5, sSum/size, k));
                }
            }
        }
    }
}