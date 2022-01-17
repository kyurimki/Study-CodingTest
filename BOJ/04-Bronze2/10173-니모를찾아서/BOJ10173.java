import java.io.*;

public class BOJ10173 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            
            if(input.equals("EOI")) break;

            input = input.toLowerCase();
            if(input.contains("nemo")) System.out.println("Found");
            else System.out.println("Missing");
        }
    }   
}