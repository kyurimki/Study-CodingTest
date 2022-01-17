import java.io.*;

public class BOJ11721 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int i = 0;
        for(i = 0; i < string.length()/10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(string.charAt(i*10+j));
            }
            System.out.println();
        }
        if(i*10 != string.length()) {
            for(int k = i*10; k < string.length(); k++)
            System.out.print(string.charAt(k));
        }
    }
}