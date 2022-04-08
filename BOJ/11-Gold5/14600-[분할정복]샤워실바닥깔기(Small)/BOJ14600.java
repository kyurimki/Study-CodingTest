import java.util.*;

public class BOJ14600 {
    static int n;
    static int[][] map;

    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int K = sc.nextInt();
        n = (int)Math.pow(2, K);
        map = new int[n][n];

        int x = sc.nextInt()-1;
        int y = n-sc.nextInt();
        map[y][x] = -1;

        paint(0, 0, n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                sb.append(map[i][j] + " ");
            sb.append('\n');
        }
        System.out.print(sb);
        sc.close();
    }

    private static void paint(int x, int y, int size) {
        count++;

        int nsize = size / 2;
        if(check(x, y, nsize)) map[x+nsize-1][y+nsize-1] = count;
        if(check(x+nsize, y, nsize)) map[x+nsize][y+nsize-1] = count;
        if(check(x, y+nsize, nsize)) map[x+nsize-1][y+nsize] = count;
        if(check(x+nsize, y+nsize, nsize)) map[x+nsize][y+nsize] = count;

        if(size == 2) return ;

        paint(x, y, nsize);
        paint(x+nsize, y, nsize);
        paint(x, y+nsize, nsize);
        paint(x+nsize, y+nsize, nsize);
    }

    private static boolean check(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++)
                if(map[i][j] != 0) return false;
        }
        return true;
    }
}