import java.util.*;

public class BOJ1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++) {
            String x = Integer.toBinaryString(num.charAt(i) - '0');
            if(x.length() == 1 && i != 0) x = "00" + x;
            else if(x.length() == 2 && i != 0) x = "0" + x;

            sb.append(x);
        }
        System.out.println(sb);

        sc.close();
    }
}