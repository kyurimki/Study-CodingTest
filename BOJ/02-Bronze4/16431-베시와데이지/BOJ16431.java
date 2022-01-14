import java.util.*;

public class BOJ16431 {
    public static void main(String[] args) {
        int[] b = new int[2];
        int[] d = new int[2];
        int[] j = new int[2];
        
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 2; i++) b[i] = sc.nextInt();
        for(int i = 0; i < 2; i++) d[i] = sc.nextInt();
        for(int i = 0; i < 2; i++) j[i] = sc.nextInt();

        int bTime = Math.abs(b[0]-j[0]) > Math.abs(b[1]-j[1]) ? Math.abs(b[0]-j[0]) : Math.abs(b[1]-j[1]);
        int dTime = Math.abs(d[0]-j[0]) + Math.abs(d[1]-j[1]);

        if(bTime < dTime) System.out.println("bessie");
        else if(bTime > dTime) System.out.println("daisy");
        else System.out.println("tie");
        
        sc.close();
    }
}