import java.util.*;

public class BOJ10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = "";
        while(sc.hasNextLine()) {
            input = sc.nextLine();
            int[] arr = new int[4];
            for(int i = 0; i < input.length(); i++) {
                if('a' <= input.charAt(i) && input.charAt(i) <= 'z') arr[0]++;
                else if('A' <= input.charAt(i) && input.charAt(i) <= 'Z') arr[1]++;
                else if('0' <= input.charAt(i) && input.charAt(i) <= '9') arr[2]++;
                else if(input.charAt(i) == ' ') arr[3]++;
            }
            for(int i : arr)
                sb.append(i).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
        sc.close();
    }
}