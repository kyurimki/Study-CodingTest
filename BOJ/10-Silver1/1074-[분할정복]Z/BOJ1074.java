import java.util.*;

public class BOJ1074 {
    static int n, r, c, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        divide((int)Math.pow(2, n), 0, 0);
        
        sc.close();
    }

    private static void divide(int size, int y, int x) {
        if(y == r && x == c) {
            System.out.println(count);
            return ;
        }

        if(y <= r && r < (y+size) && x <= c && c < (x+size)) {
            int nn = size/2;
            divide(nn, y, x);
            divide(nn, y, x+nn);
            divide(nn, y+nn, x);
            divide(nn, y+nn, x+nn);
        } else count += size*size;
    }
}