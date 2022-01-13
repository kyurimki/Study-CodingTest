import java.util.*;

public class BOJ18005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int ans = 0;
        if(x % 2 == 1) ans = 0;
        else {
            if((x/2)%2 == 1) ans = 1;
            else ans = 2;
        }
        System.out.println(ans);
        sc.close();
    }
}