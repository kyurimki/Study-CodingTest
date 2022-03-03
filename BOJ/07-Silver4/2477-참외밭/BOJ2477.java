import java.io.*;
import java.util.*;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int h = 0;
        int[] length = new int[6];
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            length[i] = size;
            if(i == 0)
                h = (dir+1)/4;

        }

        int total = 1;
        int max = 0;
        int hIdx = 0;
        for(int i = h; i < 6; i += 2) {
            if(max < length[i]) {
                max = length[i];
                hIdx = i;
            }
        }
        
        total *= max;
        max = 0;
        int wIdx = 0;
        for(int i = 1-h; i < 6; i += 2) {
            if(max < length[i]) {
                max = length[i];
                wIdx = i;
            }
        }
        total *= max;

        int sub = 1;
        for(int i = 1-h; i < 6; i += 2) {
            if(i != (hIdx-1+6)% 6 && i != (hIdx+1)% 6) {
                sub *= length[i];
                break;
            }
        }

        for(int i = h; i < 6; i += 2) {
            if(i != (wIdx-1+6)% 6 && i != (wIdx+1)% 6) {
                sub *= length[i];
                break;
            }
        }
        System.out.println((total-sub)*K);
    }
}