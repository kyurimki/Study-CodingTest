import java.util.*;

public class BOJ3107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        if(input.contains("::"))
            input = input.replace("::", ":group:");

        StringBuilder address = new StringBuilder();
        String[] parsed = input.split(":");
        for(String s : parsed) {
            if(s.equals("group")) {
                for(int i = parsed.length; i <= 8; i++) address.append("0000:");
            } else {
                for(int i = s.length(); i < 4; i++) address.append('0');
                address.append(s).append(':');
            }
        }
        System.out.println(address.deleteCharAt(address.length()-1));

        sc.close();
    }
}