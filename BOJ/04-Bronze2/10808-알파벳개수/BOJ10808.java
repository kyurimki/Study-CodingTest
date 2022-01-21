import java.io.*;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        int[] alphabets = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        for(char c : input) alphabets[(int)(c-'a')]++;

        for(int i = 0; i < 26; i++) System.out.print(alphabets[i] + " ");
    }
}