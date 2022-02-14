import java.util.*;

public class BOJ3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] dwarfs = new int[9];
        int sum = 0;
        for(int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = sc.nextInt();
            sum += dwarfs[i];
        }
        
        out: for(int i = 0; i < dwarfs.length-1; i++) {
            for(int j = i+1; j < dwarfs.length; j++) {
                if(sum-dwarfs[i]-dwarfs[j] == 100) {
                    dwarfs[i] = -1;
                    dwarfs[j] = -1;
                    break out;
                }
            }
        }

        for(int d : dwarfs) {
            if(d != -1)
                System.out.println(d);
        }
        
        sc.close();
    }
}