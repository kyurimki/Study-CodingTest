import java.util.*;

public class BOJ10829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        long n = sc.nextLong();
        ArrayList<Integer> arr = new ArrayList<>();

        while(n > 0) {
            long q = n % 2;
            arr.add((int)q);
            n /= 2;
        }

        for(int i = arr.size()-1; i >= 0; i--)
            sb.append(arr.get(i));

        System.out.println(sb);

        sc.close();
    }
}