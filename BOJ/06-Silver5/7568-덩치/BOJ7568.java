import java.io.*;
import java.util.*;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++)
                data[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(data[i][0] < data[j][0] && data[i][1] < data[j][1])
                    rank++;
            }
            System.out.print(rank + " ");
        }
    }
}