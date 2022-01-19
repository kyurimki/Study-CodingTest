import java.util.*;

public class BOJ12790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int[] xp = new int[4];
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 4; k++) xp[k] += sc.nextInt();
            }
            if(xp[0] < 1) xp[0] = 1;
            if(xp[1] < 1) xp[1] = 1;
            if(xp[2] < 0) xp[2] = 0;

            System.out.println(1*xp[0]+5*xp[1]+2*xp[2]+2*xp[3]);
        }
        sc.close();
    }
}