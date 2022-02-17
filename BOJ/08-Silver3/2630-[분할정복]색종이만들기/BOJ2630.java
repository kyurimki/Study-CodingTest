import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int[][] origami;

    static int[] count = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        origami = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                origami[i][j] = Integer.parseInt(st.nextToken());
            }
        }

            divide(0, 0, N);

            System.out.println(count[0]);
            System.out.println(count[1]);
    }

    private static void divide(int x, int y, int size) {
        if(isAvailable(x, y, size)) {
            count[origami[x][y]]++;
            return ;
        }
        
        int nn = size / 2;
        divide(x, y, nn);
        divide(x, y+nn, nn);
        divide(x+nn, y, nn);
        divide(x+nn, y+nn, nn);
    }

    private static boolean isAvailable(int x, int y, int size) {
        int start = origami[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(start != origami[i][j])
                    return false;
            }
        }
        return true;
    }
}