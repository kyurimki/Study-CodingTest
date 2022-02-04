import java.io.*;
import java.util.*;

public class SWEA1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            int[] boxes = new int[100];

            String[] input = br.readLine().split(" ");
            for(int i = 0; i < 100; i++)
                boxes[i] = Integer.parseInt(input[i]);

            for(int i = 0; i < dump; i++) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }

            Arrays.sort(boxes);

            System.out.printf("#%d %d\n", t, boxes[99]-boxes[0]);
        }
    }
}