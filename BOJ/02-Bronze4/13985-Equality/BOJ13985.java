import java.io.*;

public class BOJ13985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] eq = br.readLine().toCharArray();

        System.out.println((int)(eq[0]-'0')+(int)(eq[4]-'0') == (int)(eq[8]-'0') ? "YES" : "NO");
    }
}