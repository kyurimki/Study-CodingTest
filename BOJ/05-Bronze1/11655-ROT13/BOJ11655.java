import java.io.*;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            if('a' <= input.charAt(i) && input.charAt(i) <= 'z')
                sb.append((char)(((int)(input.charAt(i)-'a')+13) % 26 + 'a'));
            else if('A' <= input.charAt(i) && input.charAt(i) <= 'Z')
                sb.append((char)(((int)(input.charAt(i)-'A')+13) % 26 + 'A'));
            else sb.append(input.charAt(i));
        }
        System.out.println(sb);
    }
}