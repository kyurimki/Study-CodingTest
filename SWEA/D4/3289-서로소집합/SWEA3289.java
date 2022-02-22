import java.io.*;
import java.util.*;

public class SWEA3289 {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            num = new int[n+1];
            for(int i = 1; i <= n; i++)
                num[i] = i;

            sb.append("#" + t + " ");

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                switch(type) {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        if(find(a) == find(b)) sb.append("1");
                        else sb.append("0");
                        break;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int find(int x) {
        if(num[x] == x) return x;

        return num[x] = find(num[x]);
    } 

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x != y) num[y] = x;
    }
}