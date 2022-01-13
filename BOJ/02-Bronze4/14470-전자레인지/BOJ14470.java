import java.util.*;

public class BOJ14470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int time = 0;
        int temp = a;

        while(temp < b) {
            if(temp < 0) {
                time += c;
                temp++;
            } else if(temp == 0) {
                time += d;
                time += e;
                temp++;
            } else {
                time += e;
                temp++;
            }
        }
        System.out.println(time);
        sc.close();
    }
}
