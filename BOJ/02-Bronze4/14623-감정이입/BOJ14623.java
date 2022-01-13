import java.util.*;

public class BOJ14623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long b1 = Long.parseLong(sc.nextLine(), 2);
        long b2 = Long.parseLong(sc.nextLine(), 2);
        System.out.println(Long.toBinaryString(b1*b2));

        sc.close();
    }
}