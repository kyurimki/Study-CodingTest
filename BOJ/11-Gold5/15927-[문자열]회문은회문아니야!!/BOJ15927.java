import java.io.*;

public class BOJ15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string = br.readLine().toCharArray();
        boolean status = false;
        int len = string.length;
        for(int i = 0; i < len/2; i++) {
            if(string[i] != string[len-i-1]) {
                System.out.println(len);
                return ;
            } else if(string[i] != string[i+1]) // ex. ZZZ처럼 한 문자로만 이루어졌을 때를 판별하기 위함
                status = true;
        }

        if(status)
            System.out.println(len-1);
        else
            System.out.println(-1);
    }
}