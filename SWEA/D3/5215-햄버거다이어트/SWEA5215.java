import java.io.*;
import java.util.*;

public class SWEA5215 {
    static int T, N, L;
    static int[] scores, calories;

    static int chosen;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scores = new int[N];
            calories = new int[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            max = 0;
            combination(0, 0, 0);
            sb.append("#" + t + " " + max +"\n");
        }
        System.out.println(sb);
    }

    private static void combination(int count, int scoreSum, int calSum) {
        if(calSum > L) return ;
        if(count == N) {
            if(max < scoreSum && calSum <= L)
                max = scoreSum;
            return ;
        }

        combination(count+1, scoreSum+scores[count], calSum+calories[count]);
        combination(count+1, scoreSum, calSum);
    }
}