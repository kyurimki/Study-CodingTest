import java.io.*;
import java.util.*;

public class BOJ2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 가로
        int c = Integer.parseInt(st.nextToken()); // 세로
        int total = 2*r + 2*c; // 블럭의 총 길이

        int n = Integer.parseInt(br.readLine()); // 상점 수
        
        int[] location = new int[n+1]; // 거리 저장, 마지막 값 = 동근 위치
        for(int i = 0; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 방향
            int dist = Integer.parseInt(st.nextToken()); // 거리

            switch(dir) { // 왼쪽 위를 시작점으로 거리 계산
                case 1: // 북쪽
                    location[i] = dist;
                    break;
                case 2: // 남쪽
                    location[i] = r + c + (r-dist);
                    break;
                case 3: // 서쪽
                    location[i] = 2*r + c + (c-dist);
                    break;
                case 4: // 동쪽
                    location[i] = r + dist;
                    break;
            }
        }

        int sum = 0;
        int start = location[n]; // 동근 위치
        for(int i = 0; i < n; i++) {
            int tmp = Math.abs(start-location[i]);
            sum += Math.min(tmp, total-tmp); // 동근 위치와 상점 간 최단 거리
        }
        System.out.println(sum);
    }
}