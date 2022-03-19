import java.io.*;
import java.util.*;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int answer = 1;
            int atLeast = score[0][1];
            for(int i = 1; i < N; i++) {
                if(score[i][1] < atLeast) {
                    answer++;
                    atLeast = score[i][1];
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}