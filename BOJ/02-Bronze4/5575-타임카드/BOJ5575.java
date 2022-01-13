import java.util.*;

public class BOJ5575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int s1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            int s2 = sc.nextInt();

            int time = ((h2*60+m2)*60+s2) - ((h1*60+m1)*60+s1);

            int s = time % 60;
            int m = (time / 60) % 60;
            int h = time / 60 / 60;
            System.out.println(h + " " + m + " " + s);
        }
        sc.close();
    }
}
