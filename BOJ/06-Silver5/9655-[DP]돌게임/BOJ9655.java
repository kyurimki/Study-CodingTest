import java.util.*;

public class BOJ9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        System.out.println(N%2 == 1 ? "SK" : "CY");
    }
}