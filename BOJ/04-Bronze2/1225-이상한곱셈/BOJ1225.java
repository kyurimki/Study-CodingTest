import java.util.*;

public class BOJ1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] A = sc.next().toCharArray();
        char[] B = sc.next().toCharArray();

        long result = 0;
        for(char a : A) 
            for(char b : B) result += (a-'0') * (b-'0');
            
        System.out.println(result);
        sc.close();
    }
}