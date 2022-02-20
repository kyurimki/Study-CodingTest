import java.io.*;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] letters = new char[5][15];
        for(int i = 0; i < 5; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++)
                letters[i][j] = input.charAt(j);
        }
        
        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(letters[i][j] == ' ' || letters[i][j] == '\0') continue;
                    sb.append(letters[i][j]);
            }
        }
        System.out.println(sb);
    }
}