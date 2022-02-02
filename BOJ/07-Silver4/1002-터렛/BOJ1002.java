import java.io.*;
import java.util.*;

public class BOJ1002 {
    static int[] x = new int[2];
    static int[] y = new int[2];
    static int[] r = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(checkPoint()).append('\n');
        }
        System.out.print(sb);
    }

    public static int checkPoint() {
        // 중점 같고, 반지름 같음
        if(x[0] == x[1] && y[0] == y[1] && r[0] == r[1])
            return -1;

        int dist = (int)(Math.pow(x[0]-x[1], 2) + Math.pow(y[0]-y[1], 2));
        // 두 원의 반지름 합 < 중점 간의 거리
        if(dist > Math.pow(r[0]+r[1], 2))
            return 0;
        // 한 원이 다른 원 안에 위치
        else if(dist < Math.pow(r[0]-r[1], 2))
            return 0;
        // 두 원이 내접
        else if(dist == Math.pow(r[0]-r[1], 2))
            return 1;
        // 두 원이 외접
        else if(dist == Math.pow(r[0]+r[1], 2))
            return 1;

        return 2;
    }
}