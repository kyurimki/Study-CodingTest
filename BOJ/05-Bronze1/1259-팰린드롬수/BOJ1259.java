import java.io.*;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while(true) {
            input = br.readLine();
            if(input.equals("0")) break;

            boolean flag = true;
            for(int i = 0; i < input.length()/2; i++) {
                if(input.charAt(i) != input.charAt(input.length()-1-i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}