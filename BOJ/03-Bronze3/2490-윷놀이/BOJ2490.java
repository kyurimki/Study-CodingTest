import java.util.*;

public class BOJ2490 {
    public static void main(String[] args) {
        char[] yut = {'E', 'A', 'B', 'C', 'D'};

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            int count = 0;
            for(int j = 0; j < 4; j++) {
                int tmp = sc.nextInt();
                if(tmp == 0) count++;
            }
            System.out.println(yut[count]);
        }
        sc.close();
    }
}