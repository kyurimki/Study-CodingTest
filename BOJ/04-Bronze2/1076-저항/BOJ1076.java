import java.io.*;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        String input = "";
        String code = "";
        for(int i = 0; i < 2; i++) {
            input = br.readLine();
            for(int j = 0; j < 10; j++) {
                if(color[j].equals(input)) code += String.valueOf(j);
            }   
        }

        input = br.readLine();
        for(int i = 0; i < 10; i++) {
            if(color[i].equals(input)) {
                System.out.println((long)(Integer.valueOf(code) * Math.pow(10, i)));
                break;
            }
        }
    }
}