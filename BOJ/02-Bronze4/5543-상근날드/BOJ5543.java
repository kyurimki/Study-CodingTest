import java.util.*;

public class BOJ5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int burger = 2001, drink = 2001;
        for(int i = 0; i < 5; i++) {
            int x = sc.nextInt();
            if(i < 3 && burger > x) {
                burger = x;
            } else if(i >= 3 && drink > x) {
                drink = x;
            }
        }
    
        System.out.println(burger+drink-50);
        sc.close();
    }
}