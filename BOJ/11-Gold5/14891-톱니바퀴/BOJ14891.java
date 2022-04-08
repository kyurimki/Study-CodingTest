import java.io.*;
import java.util.*;

public class BOJ14891 {
    static int[][] wheels;
    static int[] head;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new int[4][8];
        for(int i = 0; i < 4; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++)
                wheels[i][j] = input[j]-'0';
        }
            
        int K = Integer.parseInt(br.readLine());
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            head = new int[4];
            int no = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            simulation(no, dir);
            rotate();
        }

        int sum = 0;
        for(int i = 0; i < 4; i++) {
            int num = wheels[i][0];
            if(num == 1) sum += Math.pow(2, i);
        }
        System.out.println(sum);
    }

    private static void simulation(int n, int dir) {
        head[n] = dir;

        int b4 = n-1;
        int after = n+1;

        if(b4 >= 0 && head[b4] == 0) {
            if(wheels[b4][2] != wheels[n][6])
                simulation(b4, dir*(-1));
        }

        if(after <= 3 && head[after] == 0) {
            if(wheels[after][6] != wheels[n][2])
                simulation(after, dir*(-1));
        }
    }

    private static void rotate() {
        for(int i = 0; i < 4; i++) {
            if(head[i] != 0) {
                int[] tmp = new int[8];

                int idx;
                for(int j = 0; j < 8; j++) {
                    idx = (j+head[i]);

                    while(idx < 0) idx += 8;
                    tmp[idx % 8] = wheels[i][j];
                }
                wheels[i] = tmp;
            }
        }
    }
}