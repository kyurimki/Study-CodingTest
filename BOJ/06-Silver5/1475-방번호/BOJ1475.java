import java.io.*;
import java.util.*;

public class BOJ1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] numarr = st.nextToken().toCharArray();
        int[] nums = new int[10];

        for(char n : numarr) {
            int x = (int)(n-'0');
            nums[x]++;
        }

        int k = nums[6] + nums[9];
        if(k % 2 == 0) {
            nums[6] = k / 2;
            nums[9] = k / 2;
        } else {
            nums[6] = k / 2 + 1;
            nums[9] = k / 2 + 1;
        }

        int max = 0;
        for(int i : nums) {
            max = Math.max(i, max);
        }

        System.out.println(max);
    }
}