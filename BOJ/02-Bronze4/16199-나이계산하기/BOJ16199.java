import java.util.*;

public class BOJ16199 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] birth = new int[3];
        int[] toFind = new int[3];
        for(int i = 0; i < 3; i++) birth[i] = sc.nextInt();
        for(int i = 0; i < 3; i++) toFind[i] = sc.nextInt();

        int x = -1;
        if(birth[1] < toFind[1] || (birth[1] == toFind[1] && birth[2] <= toFind[2])) x++;
        System.out.println(toFind[0]-birth[0]+x);

        System.out.println(toFind[0]-birth[0]+1);

        System.out.println(toFind[0]-birth[0]);

        sc.close();
    }
}