import java.io.*;
import java.util.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> lStack = new Stack<Character>();
        Stack<Character> rStack = new Stack<Character>();

        String input = br.readLine();
        for(int i = 0; i < input.length(); i++)
            lStack.push(input.charAt(i));


        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(!lStack.empty()) rStack.push(lStack.pop());
                    break;
                case 'D':
                    if(!rStack.empty()) lStack.push(rStack.pop());
                    break;
                case 'B':
                    if(!lStack.empty()) lStack.pop();
                    break;
                case 'P':
                    lStack.push(command.charAt(2));
                    break;
                default:
                    break;
            }
        }
        while(!lStack.empty())
            rStack.push(lStack.pop());
        
        while(!rStack.empty())
            bw.write(rStack.pop());
        
        bw.flush();
        bw.close();
    }
}