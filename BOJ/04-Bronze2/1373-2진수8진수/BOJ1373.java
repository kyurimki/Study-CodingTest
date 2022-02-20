import java.util.*;

public class BOJ1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        while(input.length() % 3 != 0) input = "0" + input;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i += 3)
            sb.append((input.charAt(i)-'0') * 2 * 2 + (input.charAt(i+1)-'0') * 2 + (input.charAt(i+2)-'0'));
        
        System.out.println(sb);
        sc.close();
    }
}