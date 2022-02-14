import java.io.*;
import java.util.*;

public class BOJ2961 {
    static int n;
    static int[][] ingredients;
    static boolean[] visited;
    static int min;


    private static void subset(int count) {
        if(count == n) {
            int sour = 1;
            int bitter = 0;

            int vCnt = 0;
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    vCnt++;
                    sour *= ingredients[i][0];
                    bitter += ingredients[i][1];
                }
            }
            if(vCnt == 0) return ;

            min = Math.min(min, Math.abs(sour-bitter));
            return ;
        }

        visited[count] = true;
        subset(count+1);

        visited[count] = false;
        subset(count+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ingredients = new int[n][2];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        subset(0);
        System.out.println(min);
    }
}