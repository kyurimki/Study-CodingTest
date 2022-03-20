import java.io.*;
import java.util.*;

public class BOJ20055 {
    static int N, K;
    static int[] belt;
    static boolean[] robot;

    static int stage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2*N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*N; i++) belt[i] = Integer.parseInt(st.nextToken());

        move();
        System.out.println(stage);
    }

    private static void move() {
        while(isAvail()) {
            // 1. 벨트, 로봇 회전
            int tmp = belt[2*N-1];
            for(int i = 2*N-1; i > 0; i--)
                belt[i] = belt[i-1];
            belt[0] = tmp;

            for(int i = N-1; i > 0; i--)
                robot[i] = robot[i-1];
            robot[0] = false;
            robot[N-1] = false;

            // 2. 로봇 이동
           for(int i = N-1; i > 0; i--) {
               if(robot[i-1] && !robot[i] && belt[i] > 0) {
                   robot[i] = true;
                   robot[i-1] = false;
                   belt[i]--;
               }
           }

            // 3. 로봇 올리기
           if(belt[0] > 0) {
               robot[0] = true;
               belt[0]--;
           }
           stage++;
        }
    }

    private static boolean isAvail() {
        int cnt = 0;

        for(int i = 0; i < 2*N; i++) {
            if(belt[i] == 0) cnt++;

            if(cnt >= K) return false;
        }
        return true;
    }
}