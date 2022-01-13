import java.util.*;

public class BOJ14264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double l = sc.nextDouble();
        System.out.println(String.format("%.10f", l*l/4*Math.sqrt(3)));
        sc.close();
    }
}