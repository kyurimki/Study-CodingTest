import java.io.*;

public class BOJJ5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            String input = br.readLine();
            int size = (int)Math.sqrt(input.length());
            char[][] letter = new char[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++)
                    letter[i][j] = input.charAt(size*i+j);
            }

            for(int i = size-1; i >= 0; i--) {
                for(int j = 0; j < size; j++)
                    sb.append(letter[j][i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}