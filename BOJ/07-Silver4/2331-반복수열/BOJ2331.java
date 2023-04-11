import java.util.*;

public class BOJ2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();
        sc.close();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);

        while(true) {
            int sum = getNextNum(A, P);

            if(list.contains(sum)) {
                System.out.println(list.indexOf(sum));
                break;
            }

            list.add(sum);
            A = sum;
        }
    }

    static int getNextNum(int A, int P) {
        int result = 0;
        while(A != 0) {
            result += Math.pow(A%10, (double)P);
            A /= 10;
        }
        return result;
    }
}