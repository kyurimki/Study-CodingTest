import java.io.*;

public class BOJ20499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split("/");

        int k = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int a = Integer.parseInt(input[2]);
        
        if(k+a < d || d == 0) {
            System.out.println("hasu");
        } else{
            System.out.println("gosu");
        }
    }
}