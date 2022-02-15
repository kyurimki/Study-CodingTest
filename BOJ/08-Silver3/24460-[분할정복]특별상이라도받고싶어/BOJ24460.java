import java.io.*;
import java.util.*;

public class BOJ24460 {
    static int N;
    static long[][] seats;

    static ArrayList<Long> cand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seats = new long[N][N];
        cand = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());    
            for(int j = 0; j < N; j++)
                seats[i][j] = Long.parseLong(st.nextToken());
        }

        if(N == 1) System.out.println(seats[0][0]);
        else {
            System.out.println(divide(N, 0, 0));
        }
    }

    private static long divide(int size, int y, int x) {
        if(size == 2) {
            long[] tmp = {seats[y][x], seats[y+1][x], seats[y][x+1], seats[y+1][x+1]};
            Arrays.sort(tmp);
            return tmp[1];
        }
        
        int nn = size/2;
        long[] tmp = {divide(nn, y, x), divide(nn, y, x+nn), divide(nn, y+nn, x), divide(nn, y+nn, x+nn)};
        Arrays.sort(tmp);
        return tmp[1];
    }
}