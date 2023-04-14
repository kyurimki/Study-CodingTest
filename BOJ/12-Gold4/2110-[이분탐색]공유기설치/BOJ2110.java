import java.io.*;
import java.util.*;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for(int i = 0; i < N; i++) houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int answer = 0;
        int left = 1; // 최소 길이
        int right = houses[N-1] - houses[0]; // 최대 길이
        while(left <= right) {
            int mid = (left+right)/2;
            int start = houses[0];
            int count = 1;
            for(int i = 0; i < N; i++) {
                int dist = houses[i] - start;
                if(dist >= mid) {
                    count++;
                    start = houses[i];
                }
            }
            if(count >= C) {
                left = mid + 1;
                answer = mid;
            } else right = mid - 1;
        }
        System.out.println(answer);
    }
}