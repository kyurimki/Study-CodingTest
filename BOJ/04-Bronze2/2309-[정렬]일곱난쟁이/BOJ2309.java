import java.util.*;

public class BOJ2309 {
    public static void main(String[] args) {
        int[] dwarfs = new int[9];
        
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
            sum += dwarfs[i];
        }

        boolean flag = false;
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = 101;
                    dwarfs[j] = 101;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Arrays.sort(dwarfs);

        for(int i = 0; i < 7; i++) {
            System.out.println(dwarfs[i]);
        }

        sc.close();
    }
}