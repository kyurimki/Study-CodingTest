import java.util.*;

public class BOJ11729 {
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        
        int n = sc.nextInt();
        hanoi(n, 1, 2, 3);

        System.out.println(sb.length()/4);
        System.out.print(sb);
        
        sc.close();
    }

    private static void hanoi(int n, int start, int tmp, int to) {
        if(n == 1) {
            sb.append(start + " " + to).append('\n');
            return ;
        }

        hanoi(n-1, start, to, tmp);

        sb.append(start + " " + to).append('\n');

        hanoi(n-1, tmp, start, to);
    }
}