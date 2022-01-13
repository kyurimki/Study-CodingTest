import java.util.*;

public class BOJ20976 {
    public static void main(String[] args) {
        int[] input = new int[3];

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) input[i] = sc.nextInt();

        Arrays.sort(input);
        System.out.println(input[1]);

        sc.close();
    }
}