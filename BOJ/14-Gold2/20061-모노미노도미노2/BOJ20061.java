import java.io.*;
import java.util.*;

public class BOJ20061 {
    static boolean[][] blue, green;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        blue = new boolean[4][6];
        green = new boolean[6][4];

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            simulation(t, x, y);
        }
    }

    private static void simulation(int t, int x, int y) {
        switch(t) {
            case 1:
                blue[x][0] = true;
                for(int j = 1; j < 6; j++) {
                    if(blue[x][j]) {}
                }
                green[0][y] = true;
            case 2:
            case 3:
        }
    }
}
