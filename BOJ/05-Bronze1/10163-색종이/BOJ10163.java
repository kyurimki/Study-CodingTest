import java.io.*;
import java.util.*;

public class BOJ10163 {
    static int SIZE = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[SIZE][SIZE];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());;
            int h = Integer.parseInt(st.nextToken());

            addPaper(field, x, y, w, h, i);
        }
        System.out.print(count(field, N));
    }

    static void addPaper(int[][] field, int x, int y, int w, int h, int color) {
        for(int i = y; i < y+h; i++) {
            for(int j = x; j < x+w; j++) field[i][j] = color;
        }
    }

    static StringBuilder count(int[][] field, int N) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            int count = 0;
            for(int j = 0; j < SIZE; j++) {
                for(int k = 0; k < SIZE; k++)
                if(field[j][k] == i) count++;
            }
            sb.append(count).append('\n');
        }
        return sb;
    }
}